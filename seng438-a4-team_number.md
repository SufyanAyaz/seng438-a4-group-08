**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group \#:      |     |
| -------------- | --- |
| Student Names: |     |
|                |     |
|                |     |
|                |     |

# Introduction


# Analysis of 10 Mutants of the Range class 

# Report all the statistics and the mutation score for each test class
DataUtilities:

Original:
![old mutation](Images/DataUtilitiesOld.png)
Updated:
![new mutation](Images/DataUtilitiesUpdated.png)

Originally when we ran the PIT mutation tests, we had a line coverage of 100%, a mutation coverage of 89% and a test strength of 89% as well. After updating the tests we were able get an increase of 4% for our mutation coverage. So after updating the tests we got a line coverage of 100%, a mutation coverage of 93% and a test strength of 93% as well.

# Analysis drawn on the effectiveness of each of the test classes
Range:


DataUtilities:

We were tasked with increasing the mutation coverage of the DataUtilities class by 10%. However we were unable to achieve an increase of 10%. This was due to two main problems, with the first being that our old test cases were already really good as they originally yielded a mutation coverage of 89%. This would mean that we would need to reach a coverage of 99% in order to achieve the 10% increase. As we added new tests based on the mutations that survived we were able to kill off a fair bit of the surviving mutants. This then resulted in an increase of our mutation coverage by 4%. However we are unable to increase the result any further, due to the second issue which was equivalent mutants. Most of the remaining mutants after we increased the mutation score were equivalent mutants. This meant that they had the same behavior as the original code, as a result it is impossible to create tests for these cases. Originally we had started off with 79 mutants that had survived, but were able to decrease that number to 49 surviving mutants, with the remaining mutants being classified as equivalent mutants.


# A discussion on the effect of equivalent mutants on mutation score accuracy

# A discussion of what could have been done to improve the mutation score of the test suites

In order to improve our mutation coverage from our original test suit we initially assessed the accuracy of our original tests by running the PIT mutation tests to both view the accuracy and the tested mutants. We then identified the surviving mutants, and divided them into two different categories. The first being killable, for mutants we could kill by adding new tests, and the second was unkillable, for equivalent mutants which we could not kill. After that we went through and began determining how to kill each killable mutant, by looking at things like input values. After we had a better idea of which mutants we could kill and how to kill them, we went ahead and created different test cases for all the killable mutants. Lastly after creating these test cases we ran them all at the same time, as the PIT mutation tests take a while to run. We then saw the results, and went through all the surviving mutants to see if our test cases were effective, for ones that still survived we repeated the process, until eventually we were left with only the equivalent mutants. 

# Why do we need mutation testing? Advantages and disadvantages of mutation testing

Code coverage metrics like statement, decision, condition and path coverage are not able to ensure the quality of a test suite. For example you can have a test suite that scores highly in these four categories however the quality and effectiveness of the test suit can prove to be very poor. As a result, mutation testing is used to evaluate the quality and effectiveness of a test suite. 

Advantages
One of the main advantages of mutation testing is that we can assess the effectiveness of a test suit. By changing the original code, and adding mutants into it, we are able to see how effective our tests are at detecting different faults in the code. Another major advantage of mutation testing is that we are able to determine weaknesses in each individual test case so that we may improve our test cases to be more effective. This allows for us to improve the overall quality of the test case as we are given a list of the surviving mutants, and we are able to make changes to hopefully kill off as many as we can.

Disadvantages
The biggest disadvantage of mutation testing is that it is very computationally intensive. This is because mutant testing will first introduce a single mutant, and then run through all the test cases, meaning that it will have to run dozens or even hundreds of times, depending on the number of mutants introduced. Also the larger the code base the more computational resources it will require. For example in this lab in order to run the mutation tests, our CPU and memory usage were through the roof, in some cases reaching 100% cpu usage and over 2gb of ram. This leads us to another issue which is computation time, because it is very computationally intensive. It also takes a long time in order to see the results, in the lab it was taking us somewhere from 5 - 10 minutes in order to see the results of the mutation tests.


# Explain your SELENUIM test case design process

# Explain the use of assertions and checkpoints

# how did you test each functionaity with different test data

# Discuss advantages and disadvantages of Selenium vs. Sikulix

# How the team work/effort was divided and managed


# Difficulties encountered, challenges overcome, and lessons learned

# Comments/feedback on the lab itself
Taha: I enjoyed seeing the new types of testing and how they work, as it gave me a better understanding of the concepts and their applications. When working with mutation testing, having to wait 5 - 10 minutes in order to see the results was not ideal. However it taught me to rely more on intuition and knowledge than the output, as we determined how to kill each mutant. On the other hand GUI testing was very fun and easy, as we needed to create a plan of action and simply act out the actions and our tests would automatically generate. Overall this lab helped me to better understand these two types of testing. 

