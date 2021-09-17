Programming Assignment: Conditionals & Loops


PLEASE REMEMBER NOT TO INCLUDE YOUR NAME (OR LATER IN THE COURSE, YOUR
PARTNER'S NAME) ANYWHERE IN THIS SUBMISSION.


/**********************************************************************
 *  What is the relationship between the number of steps n of the
 *  random walk and the mean squared distance? By relationship, we mean
 *  something like
 *                       mean squared distance = 126 n^9
 *
 *  Briefly justify your answer based on computational experiments.
 *  Describe the experiments and list several data points.
 *********************************************************************/
First test:
# of trials will stay the same at 100 but n will increment

n(steps)       |     mean squared distance
100            |     116.93
1000           |     883.85
10000          |     8881.69
100000         |     102610.97
1000000        |     1064371.49
10000000       |     9297731.29

Second test:
n will stay the same at 100 but # of trials will increment

trials  |     mean squared distance
100     |     102.29
1000    |     101.113
10000   |     100.0693
100000  |     100.84433
1000000 |     101.048097
10000000|     101.0132285


Conclusion: The amount of trials has no real effect on the mean squared distance.
The number of steps seems to have an effect on the distance. When putting my data points into
logger pro, I was able to get the best fit line: mean distance squared = 2.327 n^.9431. I also graphed
the data points on desmos which made the function look linear which is somewhat close to the best fit line equation.
When I tried smaller numbers:

n   mean squared distance
15	15
30	34
50	56
100	93
110	116
120	142
130	150
200	206
250	268
300	309

The power stayed about the same but the coefficient became 1.304. One of the things I noticed was that as the # of steps
increased, the randomness increased as well. As you can see, at the beginning the n vs mean squared distance is 1 to 1
but as the n increases, the mean squared distance varies more and more. It is hard to get a very accurate answers
because the randomness increases as n gets higher so to get a more accurate answer we would have to have multiple trials
at each step n and then average them, but the amount of trials would increase as n increases.





/**********************************************************************
 * Approximate number of hours to complete this assignment            *
 **********************************************************************/

Number of hours:


/**********************************************************************
 *  Did you receive help from classmates, past COS 126 students, or
 *  anyone else? If so, please list their names. ("A Sunday lab TA" or
 *  "Office hours on Thursday" is OK if you don't know their name.)
 **********************************************************************/

Yes or no?


/**********************************************************************
 *  Did you encounter any serious problems? If so, please describe.
 **********************************************************************/

Yes or no?


/**********************************************************************
 *  List any other comments here.
 **********************************************************************/

