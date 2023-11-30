# Lecture 5 Examples

`BadTime.java` is a bad implementation of a class to represent times.
The class is rather like a C struct, in that users are able to freely
the fields and change their values (due to the use of the `public`
modifier).  This means that there is no way of preventing a `Time` object
from getting into an invalid state.

`Time.java` is a better implementation, with private fields and public
getters & setters.  The latter all do validation to make sure that the values
supplied for hours, minutes and seconds are permissible.  This means that
a `Time` object can never get into an invalid state.  The class also defines
a range of other methods that make it useful - read the comments in the
code for more explanation.

`TimeDemo.java` is a program that informally tests the `Time` class by
creating objects and calling various methods.  `Clock.java` is a program
that uses `Time` to simulate a clock.
