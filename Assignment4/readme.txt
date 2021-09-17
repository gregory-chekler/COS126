Programming Assignment 3: Recursive Graphics


PLEASE REMEMBER NOT TO INCLUDE YOUR NAME (OR LATER IN THE COURSE, YOUR
PARTNER'S NAME) ANYWHERE IN THIS SUBMISSION.


/**********************************************************************
 * Approximate number of hours to complete this assignment            *
 **********************************************************************/

Number of hours:



/**********************************************************************
 *  Describe your artistic creation, and how you went about writing a
 *  program to produce it. If you found information about a fractal
 *  from somewhere (like our book, the booksite, or another offline or
 *  online source) cite it here.
 **********************************************************************/
 I somewhat came upon it on accident. I knew that I wanted to use the transform
 methods. Thus I would need to include an angle. I also wanted to use a function
 shape that I didn't use in the project. I realised after rereading the
 requirements and completing the program that it meant example that
 were in the textbook, thus not fulfilling the 2 distinct requirements.
 However the transform methods as well as the inclusion of the theta parameter
 should be enough. I included theta because once you get to order 6 and above,
 the lines of different blocks can get overlapped. Thus, by changing the
 direction they were oriented, it would still be possible for people to
 differentiate in order to see the pascal pattern. I was fiddling around with
 the sierpinski function in Art.java and started to get all sort of interesting
 shapes and recursion but none that I liked. I decided that I wanted some sort
 of tree similar to the on displayed at the beginning of the chapter. However,
 that began to morph into different shapes and finally, I came upon a new
 function that yielded me something representing pascals triangle. It was very
 messy and did not look good when n was higher. Thus I started to again fiddle
 around with the code until I came across the structure that is in Art.java.
 What I found most interesting is that I came upon this pascals triangle
 on my own. I then looked up how people wrote their pascal triangle recursion
 and it didn't seem anything like mine. I was delighted to see a familiar shape
 created in a completely unfamiliar way!


/**********************************************************************
 *  To get full credit on your Art.java, you need to have at least 3
 *  functions, including main(). Please list these functions below:
 **********************************************************************/

 1. public static void main(String[] args)
 2. private static void line(double x, double y, double length, double theta) {
 3. private static void pascal(int n, double x, double y, double length,
                                   double theta) {



/**********************************************************************
 *  To get full credit on your Art.java, you need to have used at least
 *  two of the criteria below. Please put an 'X' in the checkbox of the
 *   criteria that your submission fulfills, for instance:
 *     [ ] this is an unchecked criteria
 *     [X] this is a checked criteria
 **********************************************************************/

    [x] call one or more Transform2D method

    [x] use different parameters than our examples: f(n, x, y, size)

    [ ] use different StdDraw methods than in examples (e.g.,
        ellipses, arcs, text)

    [ ] number of recursive calls not constant per level (e.g.,
        conditional recursion)

    [ ] mutually recursive methods

    [ ] multiple recursive methods

    [ ] doesn't always recur from level n to level n-1

    [ ] draw between recursive calls, not just before/after all
        recursive calls

    [ ] use recursive level for secondary purpose (e.g., level
        dictates color)


/**********************************************************************
 *  Please check the following box if you do not want your Art to be
 *  shared (anonymously) with the rest of the class.
 **********************************************************************/

    [ ] I do *NOT* want my art to be shared with the class


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


