$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/com/app/features/DashboardActions.feature");
formatter.feature({
  "name": "Note on Dashboard",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@thisone"
    }
  ]
});
formatter.scenario({
  "name": "Post a note on Dashboard",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@thisone"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I logged into suiteCRM",
  "keyword": "Given "
});
formatter.match({
  "location": "UITestStepDefs.i_logged_into_suiteCRM()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I post \"Hello Everyone\"",
  "keyword": "When "
});
formatter.match({
  "location": "DashboardActionsStepDefs.i_post(String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//input[contains(@title,\u0027Post Status Update\u0027)]\"}\n  (Session info: chrome\u003d68.0.3440.106)\n  (Driver info: chromedriver\u003d2.41.578706 (5f725d1b4f0a4acbf5259df887244095596231db),platform\u003dMac OS X 10.13.6 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 0 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.11.0\u0027, revision: \u0027e59cfb3\u0027, time: \u00272018-03-11T20:26:55.152Z\u0027\nSystem info: host: \u0027adils-MacBook-Pro.local\u0027, ip: \u00272601:801:100:e350:dccd:f249:f95:189a%en0\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.13.6\u0027, java.version: \u00271.8.0_161\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, acceptSslCerts: false, applicationCacheEnabled: false, browserConnectionEnabled: false, browserName: chrome, chrome: {chromedriverVersion: 2.41.578706 (5f725d1b4f0a4a..., userDataDir: /var/folders/k_/csd_gc_d7vv...}, cssSelectorsEnabled: true, databaseEnabled: false, goog:chromeOptions: {debuggerAddress: localhost:49231}, handlesAlerts: true, hasTouchScreen: false, javascriptEnabled: true, locationContextEnabled: true, mobileEmulationEnabled: false, nativeEvents: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: MAC, platformName: MAC, rotatable: false, setWindowRect: true, takesHeapSnapshot: true, takesScreenshot: true, unexpectedAlertBehaviour: , unhandledPromptBehavior: , version: 68.0.3440.106, webStorageEnabled: true}\nSession ID: c651d9e71efbae7cc34a6570b2a1ae0b\n*** Element info: {Using\u003dxpath, value\u003d//input[contains(@title,\u0027Post Status Update\u0027)]}\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:214)\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:166)\n\tat org.openqa.selenium.remote.http.JsonHttpResponseCodec.reconstructValue(JsonHttpResponseCodec.java:40)\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:80)\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:44)\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:545)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:319)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:421)\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:361)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:311)\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\n\tat com.sun.proxy.$Proxy19.sendKeys(Unknown Source)\n\tat com.app.pages.SuiteCRMdashboardPage.postNote(SuiteCRMdashboardPage.java:63)\n\tat com.app.step_definitons.DashboardActionsStepDefs.i_post(DashboardActionsStepDefs.java:16)\n\tat ✽.I post \"Hello Everyone\"(src/test/resources/com/app/features/DashboardActions.feature:6)\n",
  "status": "failed"
});
formatter.step({
  "name": "Post should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "DashboardActionsStepDefs.post_should_be_displayed()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "status": "passed"
});
});