![storecompare](https://user-images.githubusercontent.com/22448079/38895768-d87f1a4c-4288-11e8-99ab-416e24d32da8.png)

<p align="center">
  <b>A multi-threaded Java application for comparing the price of products across multiple websites</b><br>
</p>

## Contents
* [Description](#description)
* [How to run](#how-to-run-the-program)
* [Design](#design)
* [Information](#information)
* [Technologies](#technologies)
* [Resources](#resources)
* [Wiki](https://github.com/EddieEldridge/GoLangAutomaton/wiki)

## Description
StoreCompare is a multi-threaded Java application that can be used to compare the price of products across websites such as Aliexpress and Ebay. 
It provides the user a quick and easy way to compare the prices of a product across multiple websites.

## How to run the program
This program uses the Java programming language .

To check if you have Java already installed you can run

```
java -version 
```


If you do not currently have Java installed click on the following link to download [INSTALL JAVA](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

Once downloaded and installed, check again to see if you now have Java installed. (May require a restart of PC and command prompt)

To clone the repository to your local machine, using your prefered command prompt, navigate to the folder you wish to download the files to and enter
```
git clone https://github.com/Store-Compare-Project/ITProSkills.git
```

**Run**
 Navigate to the folder you just cloned the project to (in your command prompt) and enter the following compile and run the code 

```
java -jar StoreCompare.jar
```

## Information
For more information on concepts and technologies discussed and used in this program, please refer to the [Wiki](https://github.com/Store-Compare-Project/ITProSkills/wiki) and resources below.

## Technologies
- [GO](https://golang.org/dl/)
- [Visual Studio Code](https://code.visualstudio.com/)
- [Git](https://git-scm.com/)
- [Cmder](http://cmder.net/)

## Resources
- [Thompson's Construction](https://en.wikipedia.org/wiki/Thompson%27s_construction) (For help understanding the concepts that this project is based upon)

- [Converting a regular expression to a NFA](http://www.cs.may.ie/staff/jpower/Courses/Previous/parsing/node5.html)

- [Russ Cox article on RegXP matching](https://swtch.com/~rsc/regexp/regexp1.html)


## Developers
Edward Eldridge (G00337490)

## Acknowledgments
- [Dr. Ian Mcloughlin](https://github.com/ianmcloughlin) - For help with the foundations of the project
- [Cian Gannon](https://github.com/cian2009) - For bringing my attention to the fact that '/r' and '/n' characters were being passed into the PostMatch function
