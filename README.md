SnailReporter
=============

This tool formats a Snail Export into a nice overview for you current features:

* Order by Customer
* Sum up customer work time
* Calculated time for your bill ( eg. round up to half hours )
* Sum up calculated work time
* Display only completed
* Calculate your money outcome
* Enable and Disable columns in your output

*Currently this is CommandLine only, but if someone is interested in a graphical version it is not that hard to write ;).*

**I am in contact with Vadim from SnailApp to automate a few things!**

Usage
-----

### Get Binary

    git clone https://github.com/bbnetz/SnailReporter.git && cd SnailReporter

### Needed TicketFormat

In order to run the SnailReporter you need to format your tracked time entries like this:

    [Customers Name] What you did.

### Run Binary

In order to run this package you need to create a CSV Export out of Snail. Click on Snail Icon, Settings and click on "Export...". 

     java -jar bin/SnailWorkTimeHelper.jar Path/To/Export.csv [--optionName=value]



### Available Options

```moneyShow``` defaults ```0```
- If set shows calculated money for each entry and customer.

```moneyAmount``` defaults ```5500```
- Money you get per hour in cents

```timeIntervals``` defaults ```3600```
- Minimal amount if time to caclulate your work into. ( eg. You work 27 Minutes and would love to calculate only half hours ) in seconds.

```showStart``` defaults ```1```
- Shows startTime column for task

```showStop``` defaults ```1```
- Shows stopTime column for tasks

```showStatus``` defaults ```1```
- Shows status column for tasks
 
```showNormalTime``` defaults ```1```
- Shows normal time column for tasks

```showWorkedTime``` defaults ```1```
- Shows calculated time column for tasks ( see also *timeIntervals* )

```displayOnlyCompleted``` defaults ```0```
- Ignores tasks with status different than"Completed"

SnailApp Api
-------------

In my opinion it would make a lot easier if we'd have an API available in SnailApp. Those are the required features:

* Generate CVS Export via CLI Command
* Add Fields ( eg. Payable[Checkbox], Customer[Textfield with AutoComplete?] )

Missing Feature?
----------------

If you are missing a feature don't hesitate to open an issue or add a pull request!


License Informations
--------------------

This project is running under GNU GENERAL PUBLIC LICENSE. If you need any informations about this please read LICENSE file.

Contact Informations
--------------------

Bastian Bringenberg <github@bbnetz.eu>

Version Information
-------------------

* 0.9.8 - 29.03.2014: First Version, no clean code and no code documentation!

