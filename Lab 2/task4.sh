#!/bin/bash

echo "Enter a number:"
read a
echo "Enter another number:"
read b
echo "Enter the last number:"
read c

result=0

#function for subtraction
function subtraction(){
  result=$(($1-$2))
  echo "Subtraction result is: $result"
}

#function for addition
function addition(){
  result=$(($1+$2))
  echo "Addition result is: $result"
}

#function for multiplication
function multiplication(){
  result=$(($1*$2))
  echo "Multiplication result is: $result"
}

if [ $a -gt $b ];
then
  subtraction $a $b
elif [ $c -lt $b ];
then 
  addition $c $b
elif [ $b -eq $c ];
then
  multiplication $b $c
else
  echo "Sorry! Conditions are not matched"
fi