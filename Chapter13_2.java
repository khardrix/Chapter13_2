/********************************************************************************************************************
 ********************************************************************************************************************
 *****                                        Chapter 13: Problem 2                                             *****
 *****__________________________________________________________________________________________________________*****
 *****     2.  Replace any missing @Override statements and the sound and howToEat methods from exercise 1.     *****
 *****                  Add the following statement in your main method prior to the for loop.                  *****
 *****                                                                                                          *****
 *****                          System.out.println((Animal)object[0].howToEat());                               *****
 *****                                                                                                          *****
 *****                                      Next, compile your program.                                         *****
 *****__________________________________________________________________________________________________________*****
 *****                                             Questions:                                                   *****
 *****                               Q-2a - What does this instruction do?                                      *****
 *****                               Q-2b - What error did you get and why?                                     *****
 *****                    Q-2c - Why didn't you get the same error as you received in 1c?                       *****
 *****                              Q-2d - How would you resolve this error?                                    *****
 *****                Q-2e - Do you need to add "implements Edible" in the Tiger class header?                  *****
 *****----------------------------------------------------------------------------------------------------------*****
 *****                                            Answers:                                                      *****
 *****                           Answer (Q-2a - What does this instruction do?):                                *****
 *****        Prints to the console the result of the howToEat() method, but gives an error in this case.       *****
 *****                                                                                                          *****
 *****                           Answer (Q-2b - What error did you get and why?):                               *****
 *****                              Error:(50, 36) java: cannot find symbol                                     *****
 *****                                     symbol:   variable object                                            *****
 *****                                    location: class Chapter13_2                                           *****
 *****                                                                                                          *****
 *****         We got this error, because the howToEat() method is part of the Edible interface and             *****
 *****        object[0] is a Tiger class object. Tiger extends the Animal class and the Animal class            *****
 *****      does not implement the Edible interface. So there is no howToEat() method in the Tiger class.       *****
 *****                                                                                                          *****
 *****                 Answer (Q-2c - Why didn't you get the same error as you received in 1c?):                *****
 *****           Apple extends the Fruit class and the Fruit class implements the Edible interface.             *****
 *****          So Apple should implement the howToEat() method, but we removed the implementation,             *****
 *****       So that led to its own error, which is a completely different error than what we received          *****
 *****                                          for this problem.                                               *****
 *****                                                                                                          *****
 *****                         Answer (Q-2d - How would you resolve this error?):                               *****
 *****             Change the line of code to: System.out.println((Fruit)object[2].howToEat());                 *****
 *****                     So that the line of code refers to a Fruit (Apple) object,                           *****
 *****                         which would have an implemented howToEat() method.                               *****
 *****        Or, you could change the line of code to: System.out.println((Animal)object[0].sound());          *****
 *****     Which would refer to an Animal (Tiger) object, which would have an implemented sound() method.       *****
 *****                                                                                                          *****
 *****            Answer (Q-2e - Do you need to add "implements Edible" in the Tiger class header?):            *****
 *****        Not necessarily. You could just implement a howToEat() method in Tiger, without having to         *****
 *****       implement the Edible interface. An interface is just a contract to implement all the methods       *****
 *****                                    in the interface that you implement.                                  *****
 *****----------------------------------------------------------------------------------------------------------*****
 *****                                  Course Provided Solution (13_2):                                        *****
 *****               This instruction invokes the howToEat method of object[0] which is a Tiger,                *****
 *****     so this should call Tiger's howToEat.  howToEat is a method that is part of the Edible interface.    *****
 *****   While we have implemented this for Fruit and for Chicken, it is not implemented for Animal or Tiger.   *****
 *****       So literally, howToEat is not related in any way to a Tiger and therefore we get the error:        *****
 *****                                                                                                          *****
 *****                                     error:  cannot find symbol                                           *****
 *****                                                                                                          *****
 *****                        We did not receive this error in 1c because in that case,                         *****
 *****                 we were required to implement the method for a Fruit subclass but here,                  *****
 *****         it is the code in main that references a method that doesn't exist that caused the error.        *****
 *****                                    In order to avoid this error,                                         *****
 *****          we have to add implements Edible to Tiger and then implement howToEat in the Tiger class.       *****
 *****    Note that we could just implement howToEat in this class without adding "implements Edible" as well.  *****
 ********************************************************************************************************************
 ********************************************************************************************************************/

public class Chapter13_2 {

    public static void main(String[] args) {

        Object[] objects = {new Tiger(), new Chicken(), new Apple()};

        // Added line of code from Exercise 1c, for this Exercise
        // System.out.println((Animal)object[0].howToEat());

        for(int i = 0; i < objects.length; i++){
            if(objects[i] instanceof Edible)
                System.out.println(((Edible)objects[i]).howToEat());

            if(objects[i] instanceof Animal)
                System.out.println(((Animal)objects[i]).sound());
        }
    }
}
