Hey this is my project! I used the MVP and MVVM design patterns to design 2 calculators, 
both of which are accessible with buttons. 

MVP:
The MVPFragment (view) has an interface with 2 functions: showResult(result: String) and 
showError(errorMessage: String). This way, when I pass an instance of the MVPFragment to my 
Presenter, it doesn't have access to the Fragment specific methods, instead just the methods it 
needs.The Presenter is called from the MVP Fragment, and also has an interface with functions it
will need (just a single function in this case). It then calls the model to do the operations. 

MVVM:
I have a ViewModel class that extends ViewModel and contains all the logic needed. It contains 
LiveData so the result survives a lifecycle change. Also calls the model to do operations. 

How to run:
Just click run! Everything should be working fine. 