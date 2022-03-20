## < Fragment - addtoBackStack() >
### 1. addtoBackStack() 사용 X -> add()
### 2. addtoBackStack() 사용 X -> replace()
### 3. addtoBackStack() 사용 O -> add()
### 4. addtoBackStack() 사용 O -> replace()

### 1. addtoBackStack() 사용 안하고 Fragment를 add() 했을 때
ex ) Fragment A->B->C 순서대로 add하고 C-> remove , backButtonClick
MainActivity : onCreate() -> onStart() -> onResume()
Fragment A -> add() : onAttach() -> onCreate() -> onCreateView() -> onActivityCreate() -> onStart() -> onResume()
Fragment B -> add() : onAttach() -> onCreate() -> onCreateView() -> onActivityCreate() -> onStart() -> onResume()
Fragment C -> add() : onAttach() -> onCreate() -> onCreateView() -> onActivityCreate() -> onStart() -> onResume()
Fragment C -> remove() : onPause() -> onStop() -> onDestroyView() -> onDestroy() -> onDetach()
-> Back Button Click
Activity : onPause() -> onStop() -> onDestroy()
Fragment A : onPause() -> onStop() -> onDestroyView() -> onDestroy() -> onDetach()
Fragment B : onPause() -> onStop() -> onDestroyView() -> onDestroy() -> onDetach()
