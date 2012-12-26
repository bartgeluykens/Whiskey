package org.apache.wicket.util.tester;

import static junit.framework.Assert.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import junit.framework.AssertionFailedError;
import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.Page;
import org.apache.wicket.behavior.AbstractAjaxBehavior;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.IFeedback;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.lang.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 12/26/12
 */
public class WhiskeyWicketTester extends BaseWhiskeyWicketTester {
  /** log. */
 	private static final Logger log = LoggerFactory.getLogger(WhiskeyWicketTester.class);

 	/**
 	 * Creates a <code>WhiskeyWicketTester</code> and automatically creates a <code>WebApplication</code>,
 	 * but the tester will have no home page.
 	 */
 	public WhiskeyWicketTester()
 	{
 	}

 	/**
 	 * Creates a <code>WhiskeyWicketTester</code> and automatically creates a <code>WebApplication</code>.
 	 *
 	 * @param homePage
 	 *            a home page <code>Class</code>
 	 */
 	public WhiskeyWicketTester(final Class<? extends Page> homePage)
 	{
 		super(homePage);
 	}

 	/**
 	 * Creates a <code>WhiskeyWicketTester</code>.
 	 *
 	 * @param application
 	 *            a <code>WhiskeyWicketTester</code> <code>WebApplication</code> object
 	 */
 	public WhiskeyWicketTester(final WebApplication application)
 	{
 		super(application);
 	}

 	/**
 	 * Creates a <code>WhiskeyWicketTester</code> to help unit testing.
 	 *
 	 * @param application
 	 *            a <code>WhiskeyWicketTester</code> <code>WebApplication</code> object
 	 * @param path
 	 *            the absolute path on disk to the web application's contents (e.g. war root) - may
 	 *            be <code>null</code>
 	 *
 	 * @see org.apache.wicket.mock.MockApplication#MockApplication()
 	 */
 	public WhiskeyWicketTester(final WebApplication application, final String path)
 	{
 		super(application, path);
 	}

 	/**
 	 * Creates a <code>WhiskeyWicketTester</code> to help unit testing.
 	 *
 	 * @param application
 	 *            a <code>WhiskeyWicketTester</code> <code>WebApplication</code> object
 	 * @param servletCtx
 	 *            the servlet context used as backend
 	 */
 	public WhiskeyWicketTester(WebApplication application, ServletContext servletCtx)
 	{
 		super(application, servletCtx);
 	}

 	/**
 	 * Asserts that the Ajax location header is present.
 	 */
 	public void assertAjaxLocation()
 	{
 		if (null != getLastResponse().getHeader("Location"))
 		{
 			fail("Location header should *not* be present when using Ajax");
 		}

 		String ajaxLocation = getLastResponse().getHeader("Ajax-Location");
 		if (null == ajaxLocation)
 		{
 			throw new AssertionFailedError("Ajax-Location header should be present when using Ajax");
 		}

 		int statusCode = getLastResponse().getStatus();
 		if (statusCode != 200)
 		{
 			throw new AssertionFailedError("Expected HTTP status code to be 200 (OK)");
 		}
 	}

 	/**
 	 * Asserts a <code>Component</code> class.
 	 *
 	 * @param path
 	 *            path to <code>Component</code>
 	 * @param expectedComponentClass
 	 *            expected <code>Component</code> class
 	 */
 	public void assertComponent(String path, Class<? extends Component> expectedComponentClass)
 	{
 		assertResult(isComponent(path, expectedComponentClass));
 	}

 	/**
 	 * Tests that a <code>Component</code> has been added to a <code>AjaxRequestTarget</code>, using
 	 * {@link org.apache.wicket.ajax.AjaxRequestTarget#add(Component...)}. This method actually tests that a
 	 * <code>Component</code> is on the Ajax response sent back to the client.
 	 * <p>
 	 * PLEASE NOTE! This method doesn't actually insert the <code>Component</code> in the client DOM
 	 * tree, using JavaScript. But it shouldn't be needed because you just have to trust that Wicket
 	 * Ajax JavaScript works.
 	 *
 	 * @param component
 	 *            a <code>Component</code> to be tested
 	 */
 	public void assertComponentOnAjaxResponse(Component component)
 	{
 		Result result = isComponentOnAjaxResponse(component);
 		assertResult(result);
 	}

 	/**
 	 * Tests that a <code>Component</code> has been added to a <code>AjaxRequestTarget</code>, using
 	 * {@link org.apache.wicket.ajax.AjaxRequestTarget#add(Component...)}. This method actually tests that a
 	 * <code>Component</code> is on the Ajax response sent back to the client.
 	 * <p>
 	 * PLEASE NOTE! This method doesn't actually insert the <code>Component</code> in the client DOM
 	 * tree, using JavaScript. But it shouldn't be needed because you just have to trust that Wicket
 	 * Ajax JavaScript works.
 	 *
 	 * @param componentPath
 	 *            a <code>Component</code> path to test
 	 */
 	public void assertComponentOnAjaxResponse(String componentPath)
 	{
 		assertComponentOnAjaxResponse(getComponentFromLastRenderedPage(componentPath));
 	}

 	/**
 	 * Asserts the content of last rendered page contains (matches) a given regex pattern.
 	 *
 	 * @param pattern
 	 *            a reqex pattern to match
 	 */
 	public void assertContains(String pattern)
 	{
 		assertResult(ifContains(pattern));
 	}

 	/**
 	 * The opposite of {@link #assertContains(String)}.
 	 *
 	 * @param pattern
 	 *            pattern
 	 */
 	public void assertContainsNot(String pattern)
 	{
 		assertResult(ifContainsNot(pattern));
 	}

 	/**
 	 * Asserts error-level feedback messages.
 	 *
 	 * @param expectedErrorMessages
 	 *            expected error messages
 	 */
 	public void assertErrorMessages(String... expectedErrorMessages)
 	{
 		List<Serializable> actualMessages = getMessages(FeedbackMessage.ERROR);
 		List<Serializable> msgs = new ArrayList<Serializable>();
 		for (Serializable actualMessage : actualMessages)
 		{
 			msgs.add(actualMessage.toString());
 		}
 		WicketTesterHelper.assertEquals(Arrays.asList(expectedErrorMessages), msgs);
 	}

 	/**
 	 * Assert info-level feedback messages.
 	 *
 	 * @param expectedInfoMessages
 	 *            expected info messages
 	 */
 	public void assertInfoMessages(String... expectedInfoMessages)
 	{
 		List<Serializable> actualMessages = getMessages(FeedbackMessage.INFO);
 		WicketTesterHelper.assertEquals(Arrays.asList(expectedInfoMessages), actualMessages);
 	}


 	/**
 	 * Assert that a particular feedback panel is rendering certain messages.
 	 *
 	 * NOTE: this casts the component at the specified path to a {@link FeedbackPanel}, so it will
 	 * not work with custom {@link IFeedback} implementations unless you are subclassing
 	 * {@link FeedbackPanel}
 	 *
 	 * @param path
 	 *            path to the feedback panel
 	 * @param messages
 	 *            messages expected to be rendered
 	 */
 	public void assertFeedback(String path, String... messages)
 	{
 		final FeedbackPanel fbp = (FeedbackPanel)getComponentFromLastRenderedPage(path);
 		final IModel<List<FeedbackMessage>> model = fbp.getFeedbackMessagesModel();
 		final List<FeedbackMessage> renderedMessages = model.getObject();
 		if (renderedMessages == null)
 		{
 			fail("feedback panel at path [" + path + "] returned null messages");
 		}
 		if (messages.length != renderedMessages.size())
 		{
 			fail("you expected " + messages.length + " messages for the feedback panel [" + path +
 				"], but there were actually " + renderedMessages.size());
 		}
 		for (int i = 0; i < messages.length && i < renderedMessages.size(); i++)
 		{
 			final String expected = messages[i];
 			boolean found = false;
 			for (FeedbackMessage actual : renderedMessages)
 			{
 				if (Objects.equal(expected, actual.getMessage().toString()))
 				{
 					found = true;
 					break;
 				}
 			}
 			if (!found)
 			{
 				assertResult(Result.fail("Missing expected feedback message: " + expected));
 			}
 		}
 	}

 	/**
 	 * Asserts that a <code>Component</code> is invisible.
 	 *
 	 * @param path
 	 *            path to <code>Component</code>
 	 */
 	public void assertInvisible(String path)
 	{
 		assertResult(isInvisible(path));
 	}

 	/**
 	 * Asserts the text of a <code>Label</code> <code>Component</code>.
 	 *
 	 * @param path
 	 *            path to <code>Label</code> <code>Component</code>
 	 * @param expectedLabelText
 	 *            expected text of the <code>Label</code>
 	 */
 	public void assertLabel(String path, String expectedLabelText)
 	{
 		Label label = (Label)getComponentFromLastRenderedPage(path);
 		assertEquals(expectedLabelText, label.getDefaultModelObjectAsString());
 	}

 	/**
 	 * Asserts the model value of a component.
 	 *
 	 * @param path
 	 *            path to the component on the page
 	 * @param expectedValue
 	 *            expected value of the component's model
 	 */
 	public void assertModelValue(String path, Object expectedValue)
 	{
 		Component component = getComponentFromLastRenderedPage(path);
 		assertEquals(expectedValue, component.getDefaultModelObject());
 	}

 	/**
 	 * Asserts the model of a {@link ListView}.
 	 *
 	 * @param path
 	 *            path to a {@link ListView} <code>Component</code>
 	 * @param expectedList
 	 *            expected <code>List</code> in the model of the given {@link ListView}
 	 */
 	@Override
 	public void assertListView(String path, List<?> expectedList)
 	{
 		ListView<?> listView = (ListView<?>)getComponentFromLastRenderedPage(path);
 		WicketTesterHelper.assertEquals(expectedList, listView.getList());
 	}

 	/**
 	 * Asserts no error-level feedback messages.
 	 */
 	public void assertNoErrorMessage()
 	{
 		List<Serializable> messages = getMessages(FeedbackMessage.ERROR);
 		assertTrue(
 			"expect no error message, but contains\n" + WicketTesterHelper.asLined(messages),
 			messages.isEmpty());
 	}

 	/**
 	 * Asserts no info-level feedback messages.
 	 */
 	public void assertNoInfoMessage()
 	{
 		List<Serializable> messages = getMessages(FeedbackMessage.INFO);
 		assertTrue("expect no info message, but contains\n" + WicketTesterHelper.asLined(messages),
 			messages.isEmpty());
 	}

 	/**
 	 * Asserts a last-rendered <code>Page</code> class.
 	 *
 	 * @param expectedRenderedPageClass
 	 *            expected class of last rendered <code>Page</code>
 	 */
 	public void assertRenderedPage(Class<? extends Page> expectedRenderedPageClass)
 	{
 		assertResult(isRenderedPage(expectedRenderedPageClass));
 	}

 	/**
 	 * Asserts last-rendered <code>Page</code> against an expected HTML document.
 	 * <p>
 	 * Use <code>-Dwicket.replace.expected.results=true</code> to automatically replace the expected
 	 * output file.
 	 *
 	 * @param clazz
 	 *            <code>Class</code> used to load the file (relative to <code>clazz</code> package)
 	 * @param filename
 	 *            expected output filename <code>String</code>
 	 * @throws Exception
 	 */
 	@Override
 	public void assertResultPage(final Class<?> clazz, final String filename) throws Exception
 	{
 		String document = getLastResponseAsString();
 		DiffUtil.validatePage(document, clazz, filename, true);
 	}

 	/**
 	 * Asserts last-rendered <code>Page</code> against an expected HTML document as a
 	 * <code>String</code>
 	 *
 	 * @param expectedDocument
 	 *            expected output <code>String</code>
 	 * @throws Exception
 	 */
 	public void assertResultPage(final String expectedDocument) throws Exception
 	{
 		// Validate the document
 		String document = getLastResponseAsString();
 		assertEquals(expectedDocument, document);
 	}

 	/**
 	 * Asserts that a <code>Component</code> is visible.
 	 *
 	 * @param path
 	 *            path to a <code>Component</code>
 	 */
 	public void assertVisible(String path)
 	{
 		assertResult(isVisible(path));
 	}

 	/**
 	 * assert component is enabled.
 	 *
 	 * @param path
 	 *            path to component
 	 *
 	 */
 	public void assertEnabled(String path)
 	{
 		assertResult(isEnabled(path));
 	}

 	/**
 	 * assert component is enabled.
 	 *
 	 * @param path
 	 *            path to component
 	 */
 	public void assertDisabled(String path)
 	{
 		assertResult(isDisabled(path));
 	}

 	/**
 	 * assert form component is required.
 	 *
 	 * @param path
 	 *            path to form component
 	 */
 	public void assertRequired(String path)
 	{
 		assertResult(isRequired(path));
 	}

 	/**
 	 *
 	 * @param result
 	 */
 	private void assertResult(Result result)
 	{
 		if (result.wasFailed())
 		{
 			throw new AssertionFailedError(result.getMessage());
 		}
 	}

 	/**
 	 * Checks whether a component is visible and/or enabled before usage
 	 *
 	 * @param component
 	 */
 	public void assertUsability(final Component component)
 	{
 		checkUsability(component, true);
 	}

 	/**
 	 *
 	 * @param link
 	 */
 	public void clickLink(Component link)
 	{
 		clickLink(link.getPageRelativePath());
 	}

 	/**
 	 * Asserts that that the BookmarkablePageLink<?> identified by "id" points to the page as
 	 * expected - including parameters.
 	 *
 	 * @param id
 	 * @param pageClass
 	 * @param parameters
 	 */
 	public void assertBookmarkablePageLink(final String id,
 		final Class<? extends WebPage> pageClass, final PageParameters parameters)
 	{
 		BookmarkablePageLink<?> pageLink;
 		try
 		{
 			pageLink = (BookmarkablePageLink<?>)getComponentFromLastRenderedPage(id);
 		}
 		catch (ClassCastException e)
 		{
 			throw new IllegalArgumentException("Component with id:" + id +
 				" is not a BookmarkablePageLink");
 		}

 		assertEquals("BookmarkablePageLink: " + id + " is pointing to the wrong page", pageClass,
 			pageLink.getPageClass());

 		assertEquals("One or more of the parameters associated with the BookmarkablePageLink: " +
 			id + " do not match", parameters, pageLink.getPageParameters());
 	}

 	/**
 	 * Use <code>-Dwicket.replace.expected.results=true</code> to automatically replace the expected
 	 * output file.
 	 *
 	 * @param <T>
 	 * @param testClass
 	 * @param pageClass
 	 * @param filename
 	 * @throws Exception
 	 */
 	public <T extends Page> void executeTest(final Class<?> testClass, final Class<T> pageClass,
 		final String filename) throws Exception
 	{
 		log.info("=== " + pageClass.getName() + " ===");

 		startPage(pageClass);
 		assertRenderedPage(pageClass);
 		assertResultPage(testClass, filename);
 	}

 	/**
 	 * Use <code>-Dwicket.replace.expected.results=true</code> to automatically replace the expected
 	 * output file.
 	 *
 	 * @param testClass
 	 * @param page
 	 * @param filename
 	 * @throws Exception
 	 */
 	public void executeTest(final Class<?> testClass, final Page page, final String filename)
 		throws Exception
 	{
 		log.info("=== " + page.getClass().getName() + " ===");

 		startPage(page);
 		assertRenderedPage(page.getClass());
 		assertResultPage(testClass, filename);
 	}

 	/**
 	 * Use <code>-Dwicket.replace.expected.results=true</code> to automatically replace the expected
 	 * output file.
 	 *
 	 * @param testClass
 	 * @param component
 	 * @param filename
 	 * @throws Exception
 	 */
 	public void executeTest(final Class<?> testClass, final Component component,
 		final String filename) throws Exception
 	{
 		log.info("=== " + component.getClass().getName() + " ===");

 		startComponent(component);
 		assertResultPage(testClass, filename);
 	}

 	/**
 	 * Use <code>-Dwicket.replace.expected.results=true</code> to automatically replace the expected
 	 * output file.
 	 *
 	 * @param <T>
 	 * @param testClass
 	 * @param pageClass
 	 * @param parameters
 	 * @param filename
 	 * @throws Exception
 	 */
 	public <T extends Page> void executeTest(final Class<?> testClass, final Class<T> pageClass,
 		PageParameters parameters, final String filename) throws Exception
 	{
 		log.info("=== " + pageClass.getName() + " ===");

 		startPage(pageClass, parameters);
 		assertRenderedPage(pageClass);
 		assertResultPage(testClass, filename);
 	}

 	/**
 	 *
 	 * @param testClass
 	 * @param component
 	 * @param filename
 	 * @throws Exception
 	 */
 	public void executeListener(final Class<?> testClass, final Component component,
 		final String filename) throws Exception
 	{
 		assertNotNull(component);

 		log.info("=== " + testClass.getName() + " : " + component.getPageRelativePath() + " ===");

 		executeListener(component);
 		assertResultPage(testClass, filename);
 	}

 	/**
 	 *
 	 * @param testClass
 	 * @param behavior
 	 * @param filename
 	 * @throws Exception
 	 */
 	public void executeBehavior(final Class<?> testClass, final AbstractAjaxBehavior behavior,
 		final String filename) throws Exception
 	{
 		assertNotNull(behavior);

 		log.info("=== " + testClass.getName() + " : " + behavior.toString() + " ===");

 		executeBehavior(behavior);
 		assertResultPage(testClass, filename);
 	}

 	/**
 	 * Assert that the last request redirected to the given Url.
 	 *
 	 * @param expectedRedirectUrl
 	 *            expected
 	 */
 	public void assertRedirectUrl(String expectedRedirectUrl)
 	{
 		String actualRedirectUrl = getLastResponse().getRedirectLocation();
 		assertEquals(expectedRedirectUrl, actualRedirectUrl);
 	}

 	/**
 	 * Returns the current Maven build directory taken from the <tt>basedir</tt> system property, or
 	 * null if not set
 	 *
 	 * @return path with a trailing slash
 	 */
 	public static String getBasedir()
 	{
 		String basedir = System.getProperty("basedir");
 		if (basedir != null)
 		{
 			basedir = basedir + "/";
 		}
 		else
 		{
 			basedir = "";
 		}
 		return basedir;
 	}


}
