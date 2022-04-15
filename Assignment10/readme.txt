Final Programming Project: Atomic Nature of Matter

/**********************************************************************
 * Approximate number of hours to complete this assignment            *
 **********************************************************************/

Number of hours:


/**************************************************************************
 *  The input size n for BeadTracker is the product of the number of      *
 *  pixels per frame and the number of frames. What is the estimated      *
 *  running time (in seconds) of BeadTracker as a function of n?          *
 *  Justify your answer with empirical data and explain how you used it.  *
 *  Your answer should be of the form a*n^b where b is an integer.        *
 **************************************************************************/
n               time                       Tn/T(n/2)
------------------------------------------------------------
10             .406 seconds
20            0.537 seconds                 1.3227
40            0.84 seconds                  1.5642
80            1.424 seconds                 1.6952
160           2.578 seconds                 1.8104

It seems that the ratio's of Tn/T(n/2) seems to approach ~2.
If Tn/T(n/2) = 2^b ----> 2^b = 2 == log(2) = b = 1

a  = (2.578 - 1.424) / (160 - 80) = .014425

The running time as a function of n (Tn = a n^b) ~ .014425 * n

Therefore the running time is linear


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



/**************************************************************************
 *  List any other comments here.                                         *
 **************************************************************************/
