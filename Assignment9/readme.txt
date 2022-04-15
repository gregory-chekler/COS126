Programming Assignment: Traveling Salesperson Problem


PLEASE REMEMBER NOT TO INCLUDE YOUR NAME (OR YOUR PARTNER'S NAME)
ANYWHERE IN THIS SUBMISSION.


/**********************************************************************
 * Approximate number of hours to complete this assignment            *
 **********************************************************************/

Number of hours:



/**********************************************************************
 *  Explain how you implemented the nearest insertion heuristic.      *
 **********************************************************************/
I followed the google document, but the idea was to check the distance of
the current node to the inserted node. If the node was closer to the
inserted node than any of the previous nodes, then I set a reference point
that would allow me to insert the new node in between the reference point
and the next node after the reference point.


/**********************************************************************
 *  Explain how you implemented the smallest insertion heuristic.     *
 *  It's sufficient to list only the differences between this         *
 *  heuristic and the nearest insertion heuristic.                    *
 **********************************************************************/
Instead of checking the distance of the current node to the inserted node,
I instead checked the overall change in length (delta) that the inserted node
would make. I the went through every node already in the circular linked list
and checked where the smallest delta would be.


/**********************************************************************
 *  First, explain why it is better to use a linked list instead of   *
 *  an array. Second, explain what is the advantage of using a        *
 *  *circularly* linked list instead of a normal linked list.         *
 **********************************************************************/

1. It is because when you want to insert a new point in the array,
you would have to move everything down one spot. First of all, this could
take a lot of time (at most O(n)) since you may have to loop through every point
just rearrange it after you figure out where the best insertion may be.
Furthermore, you wouldn't be able to account for the size of the array because
every time you insert a new point, it increases the size of the array by 1.
A linked list makes it so you can include as many points as you want without
getting into the type of trouble you would get when the array is too small.
Also, if you want to make a ring buffer which is sot of like a circular array,
the size of the ring buffer can't change.

2. The circularly linked list will always get you back to the first point
while the normal linked list will have a definite end. This makes it impossible
to get back to the beginning, and therefore would not constitute a tour in this
assignment.



/**********************************************************************
 *  In the table below, fill in the lengths that are computed by the  *
 *  two heuristics (nearest neighbor and smallest increase) that we   *
 *  ask you to implement.                                             *
 **********************************************************************/

data file      nearest neighbor     smallest increase
-----------------------------------------------------
tsp10.txt         1566.1363             1655.7462
tsp100.txt        7389.9297             4887.2190
tsp1000.txt       27868.7106            17265.6282
usa13509.txt      77449.9794            45074.7769

/**********************************************************************
 *  Do two timing analyses. Estimate the running time (in seconds)    *
 *  of each heuristic as a function of n, using expressions of the    *
 *  form: a * n^b, where b is an integer.                             *
 *                                                                    *
 *  Explain how you determined each of your answers.                  *
 *                                                                    *
 *  To get your data points, run the two heuristics for n = 1,000,    *
 *  and repeatedly double n until the execution time exceeds 60       *
 *  seconds.                                                          *
 *                                                                    *
 *  You may use TSPTimer to help do this, as per the checklist.       *
 *  If you do so, execute it with the -Xint option. This turns off    *
 *  various compiler optimizations, which helps normalize and         *
 *  stabilize the timing data that you collect.                       *
 *                                                                    *
 *  (If n = 1,000 takes over 60 seconds, your code is too slow.       *
 *  See the checklist for a suggestion on how to fix it.)             *
 **********************************************************************/

n               nearest time           smallest time
------------------------------------------------------------
1000            0.068 seconds          0.195 seconds
2000            0.258 seconds          0.758 seconds
4000            1.006 seconds          3.091 seconds
8000            4.003 seconds          12.342 seconds
16000           16.175 seconds         50.51 seconds
32000           64.242 seconds         196.865 seconds


/**********************************************************************
 *  If you implemented your own heuristic, please describe here how   *
 *  it differs from the assignments' heuristics, and why you think it *
 *  will perform better.                                              *
 **********************************************************************/

[ if you made a Leaderboard submission, you may copy your answer here ]



/**********************************************************************
 *  If you implemented your own heuristic, please provide the lengths *
 *  of these heuristics for the following two input files.            *
 **********************************************************************/

[ if you made a Leaderboard submission, you may copy your answer here ]

- distance on tsp1000.txt:
- distance on usa13509.txt:



/**********************************************************************
 *  Did you receive help from classmates, past COS 126 students, or
 *  anyone else? If so, please list their names.  ("A Sunday lab TA"
 *  or "Office hours on Thursday" is ok if you don't know their name.)
 **********************************************************************/

Yes or no?



/**********************************************************************
 *  Did you encounter any serious problems? If so, please describe.
 **********************************************************************/

Yes or no?



/**********************************************************************
 *  List any other comments here.
 **********************************************************************/

