# Study MVVM-Pattern

- 안드로이드 아키텍쳐 패턴 중 MVVM 패턴에 대해서 자세히 이해 및 구현을 위한 레포지트리.

스스로 정리한 아키텍쳐 패턴 - [Android-Architecture](https://github.com/KRMKGOLD/Android-Architecture)

**다시 생각해 보는 MVVM!**

1. MVVM 패턴?

![](https://cdn-images-1.medium.com/max/1600/1*VLhXURHL9rGlxNYe9ydqVg.png)

- Model, View, ViewModel로 구성된 안드로이드 아키텍쳐 패턴.
- 등장 이유 : MVC의 단점을 보안한 MVP가 여러가지 문제를 가지고 있기 때문
  - View와 Presenter의 강한 의존성 : View와 Model은 의존성이 없어졌으나, View와 Presenter가 1 : 1로 강한 의존성을 가지고 있기 때문이다.
  - 비대해지는 Presenter : 많아지는 비즈니스 로직에 의해서 Presenter에 코드가 많이 모인다.
  - 이외의 여러가지 문제들 : 많아지는 boilerplate code, 복잡해지는 Presenter 코드에 의한 떨어지는 유지보수성
- View : 사용자에게 보여주는 UI, Observable 변수와 Action에 유연하게 Bind, ViewModel에 bindable함.
- ViewModel : **View를 나타내주기 위한 Model**, View의 Presentation Logic단을 처리한다.
  - View의 상태와 행동이 추상화된 것이다.
- Model : MVP와 같은 역할, DB나 저장소에 접근해 데이터를 제어.



- View - ViewModel 관계
  - View와 ViewModel은 n : m 관계로, 하나의 View가 여러 ViewModel에 조합 될 수 있고, 하나의 ViewModel이 여러 View에 적용될 수 있다.
  - 재사용성이 용이하다.
  - View는 ViewModel에 bindable하다?
    - 사용자의 Action에 의해 입력을 받았을 때 (View -> ViewModel)
    - 사용자에 Action에 따른 View의 상태 변화 (ViewModel -> View)
- **결론과 장점**
  - View 의존성 제거 -> 효과적 분리
  - ViewModel 단독 테스트 -> 테스트 용이성 증가
  - **Databinding**을 통해 수많은 boilerplate 코드를 줄일 수 있음!



2. Remind MVVM in Android Framework - [송유섭님의 MVVM 발표](https://tv.naver.com/v/4637223)

   ![](https://kaidroid.me/assets/images/mvvm_impl.png)

   - 많은 사람들의 착각 : **MVVM의 ViewModel과 AAC의 ViewModel은 동일하다.** -> ViewModel의 개념을 잘못 이해하고 있는 것이다!
     - AAC의 ViewModel의 의도 : Activity와 Fragment의 LifeCycle의 의존성을 낮추는 것
     - MVVM는 View와 ViewModel 관계는, View와 ViewModel의 연결을 최소화하려는 것을 모두 전제로 잡고 있음.
     - MVVM에서 View는 오직 **xml**, not Activity / Fragment.
   - 실제로 의도하는 것은 ViewModel과 View가 직접적인 연결이 없어야 하는데, 서로가 서로를 모른 채 구현이 안 된다 -> 그래서 **DataBinding**을 사용하는 것이다.
   - MVVM을 이해하기 위해서는 MVVM의 시작인 Microsoft .NET 문서를 확인해야 한다. Not Google Docs!
   - 안드로이드 개발의 문제
     - 생명주기, Databinding으로 어려운 View 이벤트, Context 접근.
     - 생명주기 -> RxBinding, RxLifecycle...



3. MVVM으로 개발하기 앞서...

   - 필요한 지식 ? : **Databinding**, RxJava, LiveData... (있으면 좋다고는 하는데... 어렵다.)
   - 처음 시작하는 사람에게 맞는 **Basic MVVM Sample**이 많이 적고, 모두들 다르게 접근하고 있다.
   - 필요한 지식의 접근 : 어차피 나중에 많이 쓸거 공부는 필수다
     - [DataBinding(Android Docs)](https://developer.android.com/topic/libraries/data-binding?hl=ko)
     - [RxJava-Study(개인 레포)](https://github.com/KRMKGOLD/RxJava-Study)
     - [LiveData(AAC 번역본)](http://dktfrmaster.blogspot.com/2018/02/livedata.html)
     - [LiveData Study(Jetpack-Study Repo)](https://github.com/KRMKGOLD/Android-Jetpack-Study/tree/master/LiveData)
   

4. 진짜 MVVM으로 개발 시작!!

   - [가장 크게 참고한 사이트 - 쎄미님의 MVVM 개발기](http://susemi99.kr/page/2/?s=MVVM&submit=Search)
     - 물론 사람마다 MVVM을 다르게 개발하기도 하고, 사용하는 기술도 제각각이나, 일단 이걸 참고해서 공부한다.
     - 쎄미님의 개발 방식을 비슷하게 따라가 브랜치로 나누어 개발한다.
     - 목표는 Retrofit2 + RxJava + LiveData + DataBinding.
