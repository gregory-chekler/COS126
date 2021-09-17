Programming Assignment: Hamming Codes

/**********************************************************************
 * Approximate number of hours to complete this assignment            *
 **********************************************************************/

Number of hours:


/**********************************************************************
 *  Which simulator did you use to develop your TOY programs?
 *  TOY.java or Visual X-TOY 7.1 (the toy.jar)?
 **********************************************************************/



/**********************************************************************
 *  Describe what, if anything, you use each of the registers for
 *  in encode.toy.
 **********************************************************************/
R[1]: m1
R[2]: m2
R[3]: m3
R[4]: m4
R[5]: p1
R[6]: p2
R[7]: p3
R[8]:
R[9]:
R[A]:
R[B]:
R[C]:
R[D]:
R[E]:
R[F]:


/**********************************************************************
 *  Describe what, if anything, you use each of the registers for
 *  in decode.toy.
 **********************************************************************/
R[1]: m1
R[2]: m2
R[3]: m3
R[4]: m4
R[5]: p1
R[6]: p2
R[7]: p3
R[8]: constant 1
R[9]: c1
R[A]: c2
R[B]: c3
R[C]: counter (for the if statements when summing combo of c1, c2 and/or c3)
R[D]: constant 2
R[E]: constant 3
R[F]:





/**********************************************************************
 *  TigerTalk - experiments with the TigerTalk Simulator
 **********************************************************************/

1. With Hamming Error Correction switched OFF, can you find an error rate
that produces errors in the transmission without errors in the
received text? For example, Alan Turing composes/sends a text, a bit
gets flipped, yet John von Neumann receives the correct text. Explain,
including the text you used.
I found when I typed in the text: "one" at a 5 % error rate, it still output one
even though there were two bits that were flipped. The interesting thing that
I noticed is that they are both parity bits. So if the hamming correction is off
then the parity bits are irrelevant and so the original message is sent.

2. With Hamming Error Correction switched ON, what error rate will
produce errors in the transmission without errors in the received
text? For example, Alan Turing composes/sends the text you used in
(1), a bit gets flipped, yet John von Neumann receives the correct
text. Explain, including the text you used.
I was able to send and receive the text: "one" with a 12% error rate. This time
there were 4 bits that were flipped. Two were parity bits and two were regular
bits. They were not in the same nibble. I noticed that when I typed in the text
and the error was still transmitted, there were always two or more bits flipped
in the same 7 bit message.

3. With Hamming Error Correction switched ON, what is the smallest
error rate that will always produce errors in received text? Explain.
for every character, there 7 bits in transmission. From what I noticed, any time
there is two or more bits, the character is corrupted. So at least 2/7 (2) of the
bits in at least one word must be flipped for there to always be an error. So,
if it were at a rate of about 28%, then there should always be an error. When I
tried this out with one character, there were a couple times when there was no
error. I tried 38%, 48%, 50%, 54% still there were times when there was no error.
Only, when I tried 58% I did not get a single correct transmission (I tried this
probably over 100 times). I am not sure if this is just coincidence but 2 * 28%
(2/7) hits very close to that number. I am not exactly sure how to prove why this
happens mathematically. I also tried using combinatorics (2^7 - 7C2 -7C1)/(2^7),
but that got me ~93% which is much higher (I may not have done it correctly, I
am a bit rusty). Empirically (that is, according to experiment), I have seem to
come across a solution and that is ~58%.

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
