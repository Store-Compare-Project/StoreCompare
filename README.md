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
The aim of this project is to write a program in the Go programming language that can
build a non-deterministic finite automaton (NFA) from a regular expression,
and can use the NFA to check if the regular expression matches any given
string of text.

## How to run the program
This program uses the Go programming language .

If you do not currently have Go installed click on the following link to download [INSTALL GO](https://golang.org/dl/)

To clone the repository to your local machine, using your prefered command prompt, navigate to the folder you wish to download the files to and enter
```
git clone https://github.com/EddieEldridge/GoLangAutomaton
```
There is two ways to run this program
1. **Build and Run**
 Navigate to the GoLangAutomata\main folder and enter the following to compile the code 
```
go build main.go
```
This will create a .exe file in your current directory.To run the file that is created (note, unless specified, Go will name the .exe after the name of the folder which contrains the main.go file. E.g. in my case, my folder is called 'main' so an .exe called 'main.exe' is created)
```
main.exe
```
2. **Run** to simply run the program in your command prompt enter the following 
```
go run main.go
```  

## Information
For more information on concepts discussed and used in this program, please refer to the [Wiki](https://github.com/EddieEldridge/GoLangAutomaton/wiki) and resources below.

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
