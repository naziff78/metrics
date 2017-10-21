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
import org.demo.bean.MetricsRegistry;
import org.demo.bean.Projet;
import org.demo.test.MetricsRegistryFactoryForTest;
import org.demo.test.ProjetFactoryForTest;

//--- Services 
import org.demo.business.service.MetricsRegistryService;
import org.demo.business.service.ProjetService;

//--- List Items 
import org.demo.web.listitem.ProjetListItem;

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
public class MetricsRegistryControllerTest {
	
	@InjectMocks
	private MetricsRegistryController metricsRegistryController;
	@Mock
	private MetricsRegistryService metricsRegistryService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private ProjetService projetService; // Injected by Spring

	private MetricsRegistryFactoryForTest metricsRegistryFactoryForTest = new MetricsRegistryFactoryForTest();
	private ProjetFactoryForTest projetFactoryForTest = new ProjetFactoryForTest();

	List<Projet> projets = new ArrayList<Projet>();

	private void givenPopulateModel() {
		Projet projet1 = projetFactoryForTest.newProjet();
		Projet projet2 = projetFactoryForTest.newProjet();
		List<Projet> projets = new ArrayList<Projet>();
		projets.add(projet1);
		projets.add(projet2);
		when(projetService.findAll()).thenReturn(projets);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<MetricsRegistry> list = new ArrayList<MetricsRegistry>();
		when(metricsRegistryService.findAll()).thenReturn(list);
		
		// When
		String viewName = metricsRegistryController.list(model);
		
		// Then
		assertEquals("metricsRegistry/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = metricsRegistryController.formForCreate(model);
		
		// Then
		assertEquals("metricsRegistry/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((MetricsRegistry)modelMap.get("metricsRegistry")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/metricsRegistry/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<ProjetListItem> projetListItems = (List<ProjetListItem>) modelMap.get("listOfProjetItems");
		assertEquals(2, projetListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		MetricsRegistry metricsRegistry = metricsRegistryFactoryForTest.newMetricsRegistry();
		Integer id = metricsRegistry.getId();
		when(metricsRegistryService.findById(id)).thenReturn(metricsRegistry);
		
		// When
		String viewName = metricsRegistryController.formForUpdate(model, id);
		
		// Then
		assertEquals("metricsRegistry/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(metricsRegistry, (MetricsRegistry) modelMap.get("metricsRegistry"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/metricsRegistry/update", modelMap.get("saveAction"));
		
		List<ProjetListItem> projetListItems = (List<ProjetListItem>) modelMap.get("listOfProjetItems");
		assertEquals(2, projetListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		MetricsRegistry metricsRegistry = metricsRegistryFactoryForTest.newMetricsRegistry();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		MetricsRegistry metricsRegistryCreated = new MetricsRegistry();
		when(metricsRegistryService.create(metricsRegistry)).thenReturn(metricsRegistryCreated); 
		
		// When
		String viewName = metricsRegistryController.create(metricsRegistry, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/metricsRegistry/form/"+metricsRegistry.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(metricsRegistryCreated, (MetricsRegistry) modelMap.get("metricsRegistry"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		MetricsRegistry metricsRegistry = metricsRegistryFactoryForTest.newMetricsRegistry();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = metricsRegistryController.create(metricsRegistry, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("metricsRegistry/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(metricsRegistry, (MetricsRegistry) modelMap.get("metricsRegistry"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/metricsRegistry/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<ProjetListItem> projetListItems = (List<ProjetListItem>) modelMap.get("listOfProjetItems");
		assertEquals(2, projetListItems.size());
		
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

		MetricsRegistry metricsRegistry = metricsRegistryFactoryForTest.newMetricsRegistry();
		
		Exception exception = new RuntimeException("test exception");
		when(metricsRegistryService.create(metricsRegistry)).thenThrow(exception);
		
		// When
		String viewName = metricsRegistryController.create(metricsRegistry, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("metricsRegistry/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(metricsRegistry, (MetricsRegistry) modelMap.get("metricsRegistry"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/metricsRegistry/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "metricsRegistry.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<ProjetListItem> projetListItems = (List<ProjetListItem>) modelMap.get("listOfProjetItems");
		assertEquals(2, projetListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		MetricsRegistry metricsRegistry = metricsRegistryFactoryForTest.newMetricsRegistry();
		Integer id = metricsRegistry.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		MetricsRegistry metricsRegistrySaved = new MetricsRegistry();
		metricsRegistrySaved.setId(id);
		when(metricsRegistryService.update(metricsRegistry)).thenReturn(metricsRegistrySaved); 
		
		// When
		String viewName = metricsRegistryController.update(metricsRegistry, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/metricsRegistry/form/"+metricsRegistry.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(metricsRegistrySaved, (MetricsRegistry) modelMap.get("metricsRegistry"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		MetricsRegistry metricsRegistry = metricsRegistryFactoryForTest.newMetricsRegistry();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = metricsRegistryController.update(metricsRegistry, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("metricsRegistry/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(metricsRegistry, (MetricsRegistry) modelMap.get("metricsRegistry"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/metricsRegistry/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<ProjetListItem> projetListItems = (List<ProjetListItem>) modelMap.get("listOfProjetItems");
		assertEquals(2, projetListItems.size());
		
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

		MetricsRegistry metricsRegistry = metricsRegistryFactoryForTest.newMetricsRegistry();
		
		Exception exception = new RuntimeException("test exception");
		when(metricsRegistryService.update(metricsRegistry)).thenThrow(exception);
		
		// When
		String viewName = metricsRegistryController.update(metricsRegistry, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("metricsRegistry/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(metricsRegistry, (MetricsRegistry) modelMap.get("metricsRegistry"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/metricsRegistry/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "metricsRegistry.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<ProjetListItem> projetListItems = (List<ProjetListItem>) modelMap.get("listOfProjetItems");
		assertEquals(2, projetListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		MetricsRegistry metricsRegistry = metricsRegistryFactoryForTest.newMetricsRegistry();
		Integer id = metricsRegistry.getId();
		
		// When
		String viewName = metricsRegistryController.delete(redirectAttributes, id);
		
		// Then
		verify(metricsRegistryService).delete(id);
		assertEquals("redirect:/metricsRegistry", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		MetricsRegistry metricsRegistry = metricsRegistryFactoryForTest.newMetricsRegistry();
		Integer id = metricsRegistry.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(metricsRegistryService).delete(id);
		
		// When
		String viewName = metricsRegistryController.delete(redirectAttributes, id);
		
		// Then
		verify(metricsRegistryService).delete(id);
		assertEquals("redirect:/metricsRegistry", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "metricsRegistry.error.delete", exception);
	}
	
	
}
