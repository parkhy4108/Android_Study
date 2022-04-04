## RecyclerView
### RecyclerView 사용법 
    1. RecyclerView 를 사용할 XML 에 RecyclerView 레이아웃 추가
    2. RecyclerView 안에 들어갈 item 의 View 레이아웃 생성 & 작성
    3. RecyclerView 와 data 를 연결시킬 Adapter 생성 & 작성
    4. RecyclerView 를 사용할 Activity or Fragment 에 Adapter 와 LayoutManager 생성 & 연결

### *4번의 과정을 거쳐 RecyclerView 를 만들어 사용할 수 있다.

### 1. RecyclerView를 사용할 XML 에 RecyclerView layout 추가
    1번의 과정은 단순하게 xml 에 RecyclerView 를 만들어서 레이아웃을 설정하면 된다.
    예를 들어 activity_itemFragment.xml 이 있다고 하자. 
    그 안에 RecyclerView 태그를 만들어 여기에 사용할거다 말해주고
    나중에 여러 과정을 통해 이 안에 item 을 넣어준다.

### 2. Recycler 안에 들어갈 item 의 View layout 작성
    1번의 과정은 아이템을 담을 상자를 만들었다고 생각하면 된다.
    상자를 만들었고 이제 그 안에 들어갈 아이템에 대해 생각해야한다.
    각 item 들을 동일한 모양으로 담을 수 만들어 담을 수 있게 그 틀을 만들어야한다.
    2번의 과정에서는 1개의 item 의 모양을 잡아준다.
    틀을 만들어서 그 안에 계속 다른 데이터를 넣어주면 빠르게 만들수 있을것이다.
    이 과정을 위해 item의 모양을 layout으로 만드는것이다.
    item 의 이름이 뭔지 , 크기는 어떻게 할건지 , 이미지는 어떻게 할것인지를 
    layout 으로 미리 모양만 잡아두면 이름, 크기, 이미지 등 데이터만 다르게 넣어 
    여러 아이템을 만들 수 있기 때문이다.

### 3. RecyclerView 와 data 를 연결시킬 Adapter 작성
    결국 RecyclerView 를 만드는건 틀들을 만들어두고 data 만 다르게 넣으면 되는 작업이다.
    이것을 위해 adpater 를 만들어서 사이사이 연결을 해주어야한다. 
    item 을 만들어 10000개의 item 이 들어있는 RecyclerView 를 만든다고 해보자.
    item 하나를 만들기 위해 이름, 가격 , 이미지 세가지의 데이터를 item.xml 에 연결해줘야한다.
    3번의 참조와 그 후 item 하나를 recyclerview 에 추가하고 이러한 과정을 만약 10000번을 하면 
    엄청난 비용이 발생할 것이다. 
    비효율적이고 시간, 공간의 큰 낭비가 발생한다.
    이러한 문제를 해결하고자 adapter 에 viewholder 를 만들어 연결하는 방법을 구현하게된다.
    예를 들어 내 핸드폰 화면은 10개의 리스트 항목만 볼수있는 크기라고 해보자.
    그럼 10000개의 아이템을 만드는 과정을 통해(이안에 또 3번씩 총 30000만번의 참조) 10000개를 
    Recyclerview 에 10000번 반복해서 넣는게 아니라
    스크롤을 올리고 내릴때 화면에 보일 10개만 만들고 
    10개의 데이터만 받아서 Recyclerview 에 연결시켜 보여주면 되지 않을까??
    만약 스크롤을 올려 view가 1번 2번 view가 안보이면 
    안보이는 view에 데이터를 호다닥 빼고 (데이터를 빼는 작업은 없다.예이다 그냥 예)
    빈 view에 다음에 올 data를 호다닥 넣어서 이어붙여 
    계속 10개만 사용하면 낭비가 줄지 않을까??
    view의 재활용 이것을 위해 viewholder가 존재한다.
    데이터만 계속 갈아주면 화면에 보일 10개만 가지고 view를 담고있는 그릇을 재활용하면 된다.
    
#### 3.1 Adpater : ListAdapter<>() , RecyclerView.Adapter<>()
     adapter 를 만들때는 필수적으로 만들어야하는 메서드가 있다.
     1) viewHolder ( item.xml 과 viewHolder 연결 )
        : viewHolder 는 item.xml 에 만든 view 들과 연결하여 하나의 item이 담긴 그릇을 만들어준다.
        
     2) onCreateViewHolder ( new viewHolder 만들어서 반환 )
        : ViewHolder 를 새로 만들어야 할 때마다 이 메서드를 호출한다.
          ViewHolder 와 연결된 View 를 생성하고 초기화 하지만 뷰의 내용을
          채우진 않는다. ViewHolder가 바인딩된 상태가 아니다.
     3) onBindViewHolder ( 새로만든 viewHolder 에 데이터 연결 )
        : RecyclerView 가 ViewHolder 를 데이터와 연결할 때 이 메서드를 호출한다.
          데이터를 가져와 뷰홀더를 
     
  
  ##### 1) ViewHolder( ) : RecyclerView.ViewHolder() { }
     여기서 item을 담을 ViewHolder 를 만든다.
     binding 을 이용해 만들면 매개변수로 binding을 받거나 아니면 view: View 를 받아서 사용하면 된다.
     class ViewHolder(var binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Data){
            binding.(something in xml id).text = data.(*something)
        }
    }
    이렇게 바인딩하고 바인딩 하는 item 의 세부항목들 view 와 data를 fun bind의 매개변수로 받아서 묶어준다.
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.textView)
        }
    }
    그냥 view 로 쓰면 이렇게 findViewByID 를 사용하여 쓰면 된다.     
       
       
  ##### 2) onCreateViewHolder( ) : ViewHolder {}
      
      override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.text_row_item, viewGroup, false)

        return ViewHolder(view)
    }
    
    만들어둔 ViewHolder 를 상속받고 view 를 Layout 에 Inflate 해준다.
    viewholder 를 여기서 Recyclerview 에 붙여준다.
    binding 을 사용했으면 
      
     val viewHolder = BusStopViewHolder(BusStopItemBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    return viewHolder   
      
  ##### 2) onBindViewHolder( ) {  }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    
    여기서 item 의 getItem(position) 
    
    protected T getItem(int position) {
        return mDiffer.getCurrentList().get(position);
    }
    
    mDiffer 를 찾아보면 final AsyncListDiffer<T> mDiffer 를 찾을 수 있다.
    
     public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<VH> {
    final AsyncListDiffer<T> mDiffer;
    ...
    
    그래서 앞에 AsyncListDiffer 를 가보면
    
    여기로 오게된다. 
    
    public class AsyncListDiffer<T> {
    private final ListUpdateCallback mUpdateCallback;
    @SuppressWarnings("WeakerAccess") /* synthetic access */
    final AsyncDifferConfig<T> mConfig;
    Executor mMainThreadExecutor;
    private static class MainThreadExecutor implements Executor {
        final Handler mHandler = new Handler(Looper.getMainLooper());
        MainThreadExecutor() {}
        @Override
        public void execute(@NonNull Runnable command) {
            mHandler.post(command);
        }
    }
    ...
    
    여기 안에 
    
    private List<T> mReadOnlyList = Collections.emptyList();
    
    
     @NonNull
    public List<T> getCurrentList() {
        return mReadOnlyList;
    }
    
    
    holder.bind(getItem(position))
    => viewholder -> bind -> getItem(position) ->  mDiffer.getCurrentList().get(position)
    -> viewholder.bind(mDiffer. Collection.emptyList(). get(position) )
    
