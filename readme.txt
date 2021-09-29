Programming Assignment: Perceptron


/**********************************************************************
 * Approximate number of hours to complete this assignment            *
 **********************************************************************/

Number of hours:


/**********************************************************************
 * What were the code style focuses for this week (this information   *
 * is available in the COS126 Java Style Guide)?                      *
 **********************************************************************/


/**********************************************************************
 * List your instance variables and the comments you had for each:    *
 **********************************************************************/
should be in code

/**********************************************************************
 * Analysis:                                                          *
 * 1. What digit is misclassified the most frequently?                *
 * 2. For this digit,  what are the top two digit that your           *
 *    MultiPerceptron incorrectly predicts?                           *
 * 3. Examine some of these misclassified images. Provide an explana- *
 *    tion what might have caused these misclassifications.           *
 **********************************************************************/

1. Most frequently misclassified digit:
9
2. Top two digits misclassified are:

7 and then it seems to be somewhat close between 8 and 4 (at different points)

3. Explanation:

The way the 9 was drawn had similarities in how a 7, 8, or 4 would be drawn.
The slants and/or circles that were on the 9 looked like they could have been
on another number. For example, on one image the circle for the 9 looked like
the top half of an 8. On another, the line on the nine looked like it could be
drawn on a 7. Other 9s looked so strange that it would be hard to say it was a
9 on first glance. However, what I think this comes to is the shading/placement
of the circle or the line. Since the perceptron looks at pixels and the grayscale
values, if the 9 were drawn fine but the placement was a little bit closer
to how the 7s were trained, it could misinterpret the 9 for a 7. This is because
the perceptron algo punishes in terms of weighted sums were vectors are used.
The vectors represent places on the image, and so if vectors are not were they
are supposed to be, that may cause confusion. Those are my thoughts/observations.


/**********************************************************************
 *  Did you receive help from classmates, past students, or
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


