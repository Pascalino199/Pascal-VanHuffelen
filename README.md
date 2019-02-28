Pascal Van Huffelen - Task 2
Just a start to give you an idea in how I would test the app

Description:
I'm working with IntelliJ IDEA on Windows 10. I chose to work with Cucumber/Gherkin to be more BDD.
To automate the android part, I chose Appium. Since I'm used to work with GEB (high lever of Selenium)
I decided to use PageFactory. The page system allows easier maintenance.
During automation, specially in agile project, maintenance gets heavy. So a solution as Page object is very welcome from my point of view.


Requirements:
- Launch Appium Server : 0.0.0.0:4723 (default)
- Have an android device connected in proper mode or an android simulator running
=> command : 'adb devices' to see if the device is available
- Automation is working in with the English version of the App.

How-to:
In a terminal, in the project folder, type : gradle -Dfile.encoding=UTF8 cucumber
or gradlew -Dfile.encoding=UTF8 cucumber
(if you don't have gradle set-up)

Output
2 Scenarios (2 passed)
19 Steps (19 passed)
0m57,277s

