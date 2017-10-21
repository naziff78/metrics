package org.demo.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

//--- Entities
import org.demo.bean.Timers;
import org.demo.bean.MetricsRegistry;
import org.demo.test.TimersFactoryForTest;
import org.demo.test.MetricsRegistryFactoryForTest;

//--- Services 
import org.demo.business.service.TimersService;
import org.demo.business.service.MetricsRegistryService;

//--- List Items 
import org.demo.web.listitem.MetricsRegistryListItem;

import org.demo.web.common.Message;
import org.demo.web.common.MessageHelper;
import org.demo.web.common.MessageType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.MessageSource;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RunWith(MockitoJUnitRunner.class)
public class TimersControllerTest {
	
	@InjectMocks
	private TimersController timersController;
	@Mock
	private TimersService timersService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private MetricsRegistryService metricsRegistryService; // Injected by Spring

	private TimersFactoryForTest timersFactoryForTest = new TimersFactoryForTest();
	private MetricsRegistryFactoryForTest metricsRegistryFactoryForTest = new MetricsRegistryFactoryForTest();

	List<MetricsRegistry> metricsRegistrys = new ArrayList<MetricsRegistry>();

	private void givenPopulateModel() {
		MetricsRegistry metricsRegistry1 = metricsRegistryFactoryForTest.newMetricsRegistry();
		MetricsRegistry metricsRegistry2 = metricsRegistryFactoryForTest.newMetricsRegistry();
		List<MetricsRegistry> metricsRegistrys = new ArrayList<MetricsRegistry>();
		metricsRegistrys.add(metricsRegistry1);
		metricsRegistrys.add(metricsRegistry2);
		when(metricsRegistryService.findAll()).thenReturn(metricsRegistrys);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<Timers> list = new ArrayList<Timers>();
		when(timersService.findAll()).thenReturn(list);
		
		// When
		String viewName = timersController.list(model);
		
		// Then
		assertEquals("timers/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = timersController.formForCreate(model);
		
		// Then
		assertEquals("timers/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((Timers)modelMap.get("timers")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/timers/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<MetricsRegistryListItem> metricsRegistryListItems = (List<MetricsRegistryListItem>) modelMap.get("listOfMetricsRegistryItems");
		assertEquals(2, metricsRegistryListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		Timers timers = timersFactoryForTest.newTimers();
		Integer id = timers.getId();
		when(timersService.findById(id)).thenReturn(timers);
		
		// When
		String viewName = timersController.formForUpdate(model, id);
		
		// Then
		assertEquals("timers/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(timers, (Timers) modelMap.get("timers"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/timers/update", modelMap.get("saveAction"));
		
		List<MetricsRegistryListItem> metricsRegistryListItems = (List<MetricsRegistryListItem>) modelMap.get("listOfMetricsRegistryItems");
		assertEquals(2, metricsRegistryListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		Timers timers = timersFactoryForTest.newTimers();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		Timers timersCreated = new Timers();
		when(timersService.create(timers)).thenReturn(timersCreated); 
		
		// When
		String viewName = timersController.create(timers, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/timers/form/"+timers.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(timersCreated, (Timers) modelMap.get("timers"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		Timers timers = timersFactoryForTest.newTimers();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = timersController.create(timers, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("timers/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(timers, (Timers) modelMap.get("timers"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/timers/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<MetricsRegistryListItem> metricsRegistryListItems = (List<MetricsRegistryListItem>) modelMap.get("listOfMetricsRegistryItems");
		assertEquals(2, metricsRegistryListItems.size());
		
	}

	@Test
	public void createException() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(false);

		Timers timers = timersFactoryForTest.newTimers();
		
		Exception exception = new RuntimeException("test exception");
		when(timersService.create(timers)).thenThrow(exception);
		
		// When
		String viewName = timersController.create(timers, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("timers/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(timers, (Timers) modelMap.get("timers"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/timers/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "timers.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<MetricsRegistryListItem> metricsRegistryListItems = (List<MetricsRegistryListItem>) modelMap.get("listOfMetricsRegistryItems");
		assertEquals(2, metricsRegistryListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		Timers timers = timersFactoryForTest.newTimers();
		Integer id = timers.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		Timers timersSaved = new Timers();
		timersSaved.setId(id);
		when(timersService.update(timers)).thenReturn(timersSaved); 
		
		// When
		String viewName = timersController.update(timers, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/timers/form/"+timers.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(timersSaved, (Timers) modelMap.get("timers"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		Timers timers = timersFactoryForTest.newTimers();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = timersController.update(timers, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("timers/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(timers, (Timers) modelMap.get("timers"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/timers/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<MetricsRegistryListItem> metricsRegistryListItems = (List<MetricsRegistryListItem>) modelMap.get("listOfMetricsRegistryItems");
		assertEquals(2, metricsRegistryListItems.size());
		
	}

	@Test
	public void updateException() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(false);

		Timers timers = timersFactoryForTest.newTimers();
		
		Exception exception = new RuntimeException("test exception");
		when(timersService.update(timers)).thenThrow(exception);
		
		// When
		String viewName = timersController.update(timers, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("timers/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(timers, (Timers) modelMap.get("timers"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/timers/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "timers.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<MetricsRegistryListItem> metricsRegistryListItems = (List<MetricsRegistryListItem>) modelMap.get("listOfMetricsRegistryItems");
		assertEquals(2, metricsRegistryListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		Timers timers = timersFactoryForTest.newTimers();
		Integer id = timers.getId();
		
		// When
		String viewName = timersController.delete(redirectAttributes, id);
		
		// Then
		verify(timersService).delete(id);
		assertEquals("redirect:/timers", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		Timers timers = timersFactoryForTest.newTimers();
		Integer id = timers.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(timersService).delete(id);
		
		// When
		String viewName = timersController.delete(redirectAttributes, id);
		
		// Then
		verify(timersService).delete(id);
		assertEquals("redirect:/timers", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "timers.error.delete", exception);
	}
	
	
}
