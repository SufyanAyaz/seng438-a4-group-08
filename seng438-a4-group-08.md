**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group: 08      |
|-----------------|
| Student 1: Sufyan Ayaz                |   
| Student 2: Muhammad Haris Kashif              |   
| Student 3: Faisal Islam               |   
| Student 4: Taha Khan                |

# Introduction


# Analysis of 10 Mutants of the Range class 

### Method: `public boolean intersects(double b0, double b1)`

#### Statement: `return (b0 < this.upper && b1 >= b0);`

1. **Mutation: Changed conditional boundary → SURVIVED**
   - **Analysis:** This mutation was reported for the `intersects(double b0, double b1)` method and survived because none of the tests written in the JUnit Test Suite for Assignment 3 covered the scenario where the argument `b0` correlated to the upper bound of the range or the argument `b1` correlated to the lower bound of the range. Therefore, the mutation survived due to lack of test coverage.

#### Statement: `if (b0 <= this.lower) {`

1. **Mutation: Removed conditional - replaced comparison check with false → KILLED**
   - **Analysis:** This mutation was applied to the `intersects(double b0, double b1)` method and was reported to be killed. Test cases in the Assignment 3 test suite were still able to reach the appropriate conclusion with regards to whether an intersection occurred or not, even when the condition `(b0 <= this.lower)` was permanently set to `false`.

2. **Mutation: Incremented (a++) double field lower → SURVIVED**
   - **Analysis:** This mutation was reported for the `intersects(double b0, double b1)` method and survived because there were no unit tests in the Assignment 3 test suite that covered the scenario where the lower bound is incremented by one after the statement `if (b0 <= this.lower)` is run. Lack of test coverage for this scenario resulted in the survival of the mutation.

### Method: `public String toString()`

#### Statement: `return ("Range[" + this.lower + "," + this.upper + "]");`

1. **Mutation: Replaced return value with "" for `org/jfree/data/Range::toString` → KILLED**
   - **Analysis:** This mutation was applied to the `toString()` method and was reported to be killed. Test cases for the `toString()` method returned the expected string representation of the range, which contradicted the mutated behavior of returning an empty string, resulting in the mutation being killed.

2. **Mutation: Incremented (a++) double field lower → SURVIVED**
   - **Analysis:** This mutation was reported for the `toString()` method and survived because there were no unit tests in the Assignment 3 test suite that covered the scenario where the lower bound is incremented by one after it is used to generate the string. Lack of test coverage for this scenario resulted in the survival of the mutation.

3. **Mutation: Incremented (a--) double field upper → SURVIVED**
   - **Analysis:** This mutation was reported for the `toString()` method and survived because there were no unit tests in the Assignment 3 test suite that covered the scenario where the upper bound is decremented by one after it is used to generate the string. Lack of test coverage for this scenario resulted in the survival of the mutation.

### Method: `public double getCentralValue()`

#### Statement: `return this.lower / 2.0 + this.upper / 2.0;`

1. **Mutation: Incremented (a++) double field lower → SURVIVED**
   - **Analysis:** This mutation was reported for the `getCentralValue()` method and survived because there were no unit tests in the Assignment 3 test suite that covered the scenario where the lower bound is incremented by one after the central value is calculated. Lack of test coverage for this scenario resulted in the survival of the mutation.

2. **Mutation: Incremented (++a) double field lower → KILLED**
   - **Analysis:** This mutation was applied to the `getCentralValue()` method and was reported to be killed. The mutation incremented the lower bound before it was used in the central value calculation, resulting in a central value that differed from the expected value, which led to the mutation being killed.

3. **Mutation: Decremented (a--) double field upper → SURVIVED**
   - **Analysis:** This mutation was reported for the `getCentralValue()` method and survived due to the fact that in our JUnit Test Suite for Assignment 3, there were no unit tests that covered the scenario where the upper bound is decremented by one after the central value is calculated. Since this scenario invlovles decrementing the upper bound after the central value is calculated, the test cases we wrote would receive the correct central value and would accept it instead of checking if the upper bound is still the same. Not being able to cover this scenario in our Assignment 3 tests for the Range class resulted in the survival of this mutation.

### Method: `public boolean contains(double value)`

#### Statement: `return (value >= this.lower && value <= this.upper);`

1. **Mutation: Replaced boolean return with true for `org/jfree/data/Range::contains` → KILLED**
   - **Analysis:** This mutation was applied to the `contains(double value)` method and was reported to be killed. Test cases were able to detect the discrepancy when the method returned `true` instead of `false`, marking the mutated behavior as incorrect and killing the mutation.


# Report all the statistics and the mutation score for each test class

## Range Class:

Original Mutation Score:
![original range class mutation score](Images\RangeOriginalMutationScore.jpg)

Updated Mutation Score:
![updated range class mutation score](Images\RangeUpdatedMutationScore.jpg)

> When we ran the PITEST software on the original test suite for the range class, we were able to achieve a line coverage of 98%, a mutation coverage score of 71%, and a test strength of 74%. After incorporating additional test cases to the Range class test suite, we were able to increase the line coverage metric to 100%, the mutation coverage score metric to 82%, and the test strength metric to 82% as well.

## DataUtilities Class:

Original:
![old mutation](Images/DataUtilitiesOld.png)

Updated:
![new mutation](Images/DataUtilitiesUpdated.png)

> Originally when we ran the PIT mutation tests, we had a line coverage of 100%, a mutation coverage of 89% and a test strength of 89% as well. After updating the tests we were able get an increase of 4% for our mutation coverage. So after updating the tests we got a line coverage of 100%, a mutation coverage of 93% and a test strength of 93% as well.

# Analysis drawn on the effectiveness of each of the test classes
### Range:

For the Range class, our test cases that were created over the course of the last two assignments were able to garner a mutation score of 71%, which is indicative of the fact that they were strong test cases, but they were not strong enough. In this assignment, we were able to implement additional test cases that increased the number of injected mutations that were killed, and were able to push the mutation score to 82%. Once we reached the threshold of an 11% increase, finding more mutants to kill became quite a difficult task. The surviving mutations that remained were either equivalent mutations (where injecting the mutation didn't change the original behavior of the source code) or were mutation that there was no way of actually isolating and interacting with in a test case (mainly mutations that manipulate local variables of methods). Overall, we would say that The Range class is quite effective at mutation detection and testing, as even though it was not able to achieve a mutation score of 100%, it was still able to kill off quite a significant portion of the injected mutations through the additional test cases.

### DataUtilities:

We were tasked with increasing the mutation coverage of the DataUtilities class by 10%. However we were unable to achieve an increase of 10%. This was due to two main problems, with the first being that our old test cases were already really good as they originally yielded a mutation coverage of 89%. This would mean that we would need to reach a coverage of 99% in order to achieve the 10% increase. As we added new tests based on the mutations that survived we were able to kill off a fair bit of the surviving mutants. This then resulted in an increase of our mutation coverage by 4%. However we are unable to increase the result any further, due to the second issue which was equivalent mutants. Most of the remaining mutants after we increased the mutation score were equivalent mutants. This meant that they had the same behavior as the original code, as a result it is impossible to create tests for these cases. Originally we had started off with 79 mutants that had survived, but were able to decrease that number to 49 surviving mutants, with the remaining mutants being classified as equivalent mutants.


# A discussion on the effect of equivalent mutants on mutation score accuracy

Equivalent mutants are mutations that are injected into the code of the program that involve syntactically manipulating the code, but semantically, the behavior of the program does not change when compared to the behavior of the original code. For example, if the original code stated `x = y + z`, an example of an equivalent mutation could be `x = y - (-z)`. Both of these code snippets are written differently syntactically, but their behaviour is the exact same no matter what the variables are set to.

Having these equivalent mutations becomes quite an issue when considering mutation testing as a whole, especially since the injection of equivalent mutants negatively affects the accuracy of the mutation coverage score. Equivalent mutants are mutations that when injected into the code, have no way to actually kill off as they would always result in what the desired behavior of the code is. The presence of these equivalent mutants then inflates the total number of mutants (with unkillable mutations), which then creates a cap for how high the mutation score can go. These equivalent mutants essentially act as a ceiling for the mutation score, and prevents the score from reaching 100% irrespective of how many test cases you add. An example of this phenomenon can be seen in this assignment where the mutation score for the DatUtilities class is capped at 93% due to there being a large presence of equivalent mutants being injected in this class.

Because of how problematic equivalent mutants can be when trying to achieve mutation coverage, it becomes important to be able to detect these equivalent mutants, such that you are able to exclude them from the mutation score calculation and test the true strength of your test cases when dealing with mutations. In order to detect these mutations, our group came to the conclusion that they could be detected in one of two ways, either manually or algorithmically. 

Implementing the manual strategy involves going through the mutation generated by a program (i.e. PITEST) and seeing how those mutations would change the code. The you can take the manipulated code and deduce whether it would always result in the same behavior as that of the original code fragment. The benefit of this method is that it is simple and easy enough to execute, but the drawbacks are that it is a very slow/tedious way of detecting equivalent mutants, and it is also possible to overlook equivalent mutants or label mutations as equivalent mutants even if they are not (it is easy to make a mistake).

Implementing the algorithmic strategy would involve going through each code statement, finding different variations of that code that would result in the same behavior, and then going through and checking which mutation would manipulate the code syntax to be one of the variations found. The benefit of this method is that it is much more accurate. Using the algorithm, you can be certain that you would be able to correctly find a lot, if not all of the equivalent mutations. The drawback with this method, though, is the complexity behind it. In order to create such an algorithm you need to have the knowledge to create a program that can find all the possible variations of a code statement, which is not a very easy feat to accomplish.


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

Sufyan: Overall, I felt that this lab was quite interesting and was effective in helping understand how mutation testing works. Being outside of the concepts we learned in class, the GUI testing was a fun little side component that I found was a nice introduction to testing the GUI of an application, especially considering that it is not something I would have considered doing or even knew how to do in the past. However, I would say, that when compared to the previous two assignments, the instructions in this lab were quite vague. I feel it would have been nice if we were given a heads up on how PITEST takes a long time to load and the errors you get at the beginning are normal. It would have also been nice to have some sort of starting information on how the SeleniumIDE worked. Even though it is quite simple and easy to understand, it required research and watching video tutorials on our part just to figure out what is going on.

Taha: I enjoyed seeing the new types of testing and how they work, as it gave me a better understanding of the concepts and their applications. When working with mutation testing, having to wait 5 - 10 minutes in order to see the results was not ideal. However it taught me to rely more on intuition and knowledge than the output, as we determined how to kill each mutant. On the other hand GUI testing was very fun and easy, as we needed to create a plan of action and simply act out the actions and our tests would automatically generate. Overall this lab helped me to better understand these two types of testing. 
