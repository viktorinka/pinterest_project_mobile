<h1 align="center"> Demo project to automate Mobile testing for service <a href="https://www.pinterest.com">Pinterest</h1>
<div align="center">
  <a href="https://www.pinterest.com"><img alt="Pinterest" src="media/Pinterest_Logo.svg.png"></a>
</div>
  
> Pinterest is social Internet service, photo hosting, allowing users to add images online, place them in thematic collections and share them with other users.

# :open_file_folder: <a name="TableOfContents">Table of contents</a>

* <a href="#Description">Description</a>
* <a href="#Technology">Tools and technologies</a>
* <a href="#HowToRun">How to run</a>
* <a href="#AllureReport">Test results report in Allure Report</a>
* <a href="#AllureTestOps">Allure TestOps integration</a>
* <a href="#Jira">Jira integration</a>
* <a href="#Telegram">Telegram Notifications</a>
* <a href="#Browserstack">Video of running tests in Browserstack</a>

<a id="Description"></a>
# :bulb: Description
The test project consists of Web, API and mobile(android) tests.\
A brief list of interesting facts about the project:
- [x] `Selenide` and `Appium` are used to control the mobile device using a web driver.
- [x] Tests can be run both locally (using `Android studio` and a mobile device `emulator`) 
- and using the `Browserstack service`, which provides access to a farm with real mobile devices
- [x] Config with `Owner` library
- [x] `Allure TestOps` integration
- [x] Autotests as test documentation
- [x] `Jenkins` runs tests
- [x] `Jira` integration


<a id="Technology"></a>
# :technologist: Tools and a technologies
<p  align="center">
  <code><img width="5%" title="IntelliJ IDEA" src="media/logo/IDEA-logo.svg"></code>
  <code><img width="5%" title="Java" src="media/logo/java-logo.svg"></code>
  <code><img width="5%" title="Selenide" src="media/logo/selenide-logo.svg"></code>
  <code><img width="5%" title="REST-Assured" src="media/logo/rest-assured-logo.svg"></code>
  <code><img width="5%" title="Gradle" src="media/logo/gradle-logo.svg"></code>
  <code><img width="5%" title="JUnit5" src="media/logo/junit5-logo.svg"></code>
  <code><img width="5%" title="Allure Report" src="media/logo/allure-Report-logo.svg"></code>
  <code><img width="5%" title="Allure TestOps" src="media/logo/allure-ee-logo.svg"></code>
  <code><img width="5%" title="Github" src="media/logo/git-logo.svg"></code>
  <code><img width="5%" title="Jenkins" src="media/logo/jenkins-logo.svg"></code>
  <code><img width="5%" title="Jira" src="media/logo/jira-logo.svg"></code>
  <code><img width="5%" title="Telegram" src="media/logo/telegram_logo.svg"></code>
  <code><img width="5%" title="Browserstack" src="media/logo/browserstack-logo.svg"></code>
  <code><img width="5%" title="Android Studio" src="media/logo/android-logo.svg"></code>
  <code><img width="5%" title="Appium" src="media/logo/appium-logo.svg"></code>
</p>

The autotests in this project are written in `Java` using `Selenide` framework.\
`Gradle` - is used as a build automation tool.  \
`JUnit5` - to execute tests.\
`REST Assured` - for easy API testing of REST services.\
`Jenkins` - CI/CD for running tests remotely.\
`Browserstack` - to run mobile tests.\
`Android Studio tools`, `Appium` - to tun mobile tests locally in a mobile device emulator.\
`Allure Report` - for test results visualisation.\
`Telegram Bot` - for test results notifications.\
`Allure TestOps` - as Test Management System.

<a id="HowToRun"></a>
# :computer: How to run

### Local running tests

```bash
gradle clean test
```

### Remote running tests

```bash
gradle clean test
-DdeviceHost=browserstack
```
### <img width="5%" src="media/logo/jenkins-logo.svg"> Running tests in [Jenkins](https://jenkins.autotests.cloud/job/pinterest_project_mobile/)

<p align="center">
  <img src="media/job-jenkins.png" alt="Jenkins" width="800">
</p>

After build is completed, in the <code><strong>*Builds history*</strong></code> opposite the build number will appear
the *Allure Report* icon, clicking on which will open the page with the generated html-report.

<a id="AllureReport">
  
## <img width="5%" src="media/logo/allure-Report-logo.svg"> Test results report in [Allure Report](https://jenkins.autotests.cloud/job/pinterest_project_mobile/18/)

<p align="center">
  <img src="media/allure-report_1.png" alt="allure-report1" width="900">
</p>
<p align="center">
  <img src="media/allure-report_2.png" alt="allure-report1" width="900">
</p>

<a id="AllureTestOPS">
  
## <img width="5%" src="media/logo/allure-ee-logo.svg"> Integration with [Allure TestOps](https://allure.autotests.cloud/launch/36557)

### Main dashboard

<p align="center">
  <img src="media/allure-tops_1.png" alt="dashboard" width="900">
</p>

### Test results

<p align="center">
  <img src="media/allure-tops_2.png" alt="testresults" width="900">
</p>

<a id="Jira">
  
## <img width="5%" src="media/logo/jira-logo.svg"> Integration with [Jira](https://jira.autotests.cloud/browse/HOMEWORK-1151)

<p align="center">
  <img src="media/jira.png" alt="jira" width="900">
</p>

<a id="Telegram">
  
## <img width="5%" src="media/logo/telegram_logo.svg"> Telegram notifications using a bot
After the build is completed, a special bot created in <code>Telegram</code>, automatically processes and sends a test run report message.

<p align="center">
<img src="media/telegram.png">
</p>

<a id="Browserstack">
  
## <img width="5%" src="media/logo/browserstack-logo.svg"> Test running example in Browserstack

A video is attached to each test in the report.

<p align="center">
  <img src="media/video.gif">
</p>

[back to Contents ⬆](#TableOfContents)
