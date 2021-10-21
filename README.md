# AT&T TDP Software Engineer Technical Assignment 

A repository for this assignment can be found at https://github.com/Sam-Berger/ATTBooks

## Overview

This main purpose of this program is to take an input of Book objects and return a custom string about the oldest 
book from the author the most books in the list.

##Usage

First you will want your IDE to build this progject with gradle. 

To run this program you can simply run Run.main()

The input for this program is an array of book objects, The array can have up to 100 books in it. You can initially 
run this with the sample bookLists I have created in Run.java. When you are ready to use your own list, I 
recommend uncommenting out in Run.java lines 25-27 and 33, and filling in the books you would like in your book list 
starting in line 26 replacing the example given. Enter books in the format title, date of publication, author, 
number of pages. You can then comment out lines 30-31 so that only your method will output to the terminal.

##Behaviors

This program works by creating Book objects. Books can only take on Steven King, Suzanne Collins, Rudyard Kipling or 
Isaac Asimov as authors per the prompt, otherwise an IllegalAgrumentException is thrown.
The BookList class manipulates a collection of books (a booklist) in 
three steps to arrive at the answer desired in the prompt, returning the oldest book by the author with the most 
books on the list.
The Run class exists to populate a list of books to actually be used by the methods of the BookList class.

##Additional Notes

There are some ambiguities in this assignment, such as what to do if there is more than one author tied for having 
the most books on the list. I decided to include a way so that all authors tied for first get something printed to 
the screen.

Additionally, what "output" means is ambiguous. I have decided that means return, rather than simply printing it to 
the screen. If the latter is the desired behavior then it would be trivial to change the output to that format.

## Who Made This?
This was completed by Sam Berger (https://sam-berger.github.io/)

