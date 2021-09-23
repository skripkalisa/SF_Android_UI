package com.example.mod21

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.*
import android.widget.*
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item.view.*

class SubscribeView(context: Context, @Nullable attributeSet: AttributeSet) : LinearLayout(context, attributeSet) {
    private val editText: EditText
    private val subscribeButton: Button

    init {
        // "Надуваем наш фрагмент"
        LayoutInflater.from(context).inflate(R.layout.subscribe, this)
        //Нужно явно указать ориентацию, если она вертикальная, иначе отображение будет не корректное

        this.orientation = VERTICAL
        // Привязываем наши View из xml (можно и без переменных обращаться к ним сразу напрямую)
        editText = findViewById<AppCompatEditText>(R.id.et_subscribe)
        subscribeButton = findViewById(R.id.btn_subscribe)

        //Вешаем слушатель на нашу кнопку, сейчас он отправляет данные из EditText в Toast, в рабочем приложении он бы отправлял данные на сервер
        subscribeButton.setOnClickListener {
            Toast.makeText(context, editText.text, Toast.LENGTH_SHORT).show()
        }
    }
}

class ViewPagerAdapter : RecyclerView.Adapter<PagerViewHolder>() {
   //Здесь хранится список наших объектов с цветом и текстом
   private val items = mutableListOf<PagerItem>()

   //Этот метод мы возвращает количество элементов в items, иногда полезно
   override fun getItemCount(): Int = items.size

   //В это методе создается VIewHolder и к нему привязывается наш item.xml
   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder =
       PagerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))

   //В это методы передаются данные из items в layout
   override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
       holder.onBind(items[position])
   }

   //Этот метод наполняет список items, нужен нам чтобы делать это извне
   fun setItems(list: List<PagerItem>) {
       items.clear()
       items.addAll(list)
   }
}



//val container = findViewById<ConstraintLayout>(R.id.container)
data class PagerItem(val color: Int, val text: String)

class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
   //В этом методе мы передаем данные из PagerItem в нашу верстку item.xml
   fun onBind(item: PagerItem) {
       //корневой элемент item.xml
       itemView.container.setBackgroundColor(item.color)
       //Текстовое поле
       itemView.textView.text = item.text
   }
}

class MainActivity : AppCompatActivity() {
    private var actionMode: ActionMode? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       //Создаем адаптер
       val pagerAdapter = ViewPagerAdapter()

       //Привязываем созданный адаптер к нашему ViewPager, который у нас в разметке
       viewPager2.adapter = pagerAdapter

       //Создаем список элементов, который передадим в адаптер
       val pagerItems = listOf<PagerItem>(
           PagerItem(ContextCompat.getColor(this, R.color.red), "Red"),
           PagerItem(ContextCompat.getColor(this, R.color.green), "Green"),
           PagerItem(ContextCompat.getColor(this, R.color.yellow), "Yellow")
       )

       //Передаем список в адаптер
       pagerAdapter.setItems(pagerItems)





        val topAppBar = findViewById<MaterialToolbar>(R.id.topAppBar)
        val textView = findViewById<TextView>(R.id.textView)

        textView.setOnLongClickListener {
            if (actionMode != null) {
                return@setOnLongClickListener false
            }

            actionMode = startActionMode(object : ActionMode.Callback {

               override fun onActionItemClicked(p0: ActionMode?, p1: MenuItem?): Boolean {
                    when (p1?.itemId) {
                        R.id.photo -> Toast.makeText(this@MainActivity, "Photo", Toast.LENGTH_SHORT)
                            .show()
                        R.id.reaction -> Toast.makeText(
                            this@MainActivity,
                            "Reaction",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    return true
                }

                override fun onCreateActionMode(p0: ActionMode?, p1: Menu?): Boolean {
                    val inflater = p0?.menuInflater
                    inflater?.inflate(R.menu.new_menu, p1)
                    p0?.title = "Select option"
                    return true
                }

                override fun onPrepareActionMode(p0: ActionMode?, p1: Menu?): Boolean {
                    return false
                }


                override fun onDestroyActionMode(mode: ActionMode?) {
                    actionMode = null
                }

            })

            return@setOnLongClickListener true

        }

        topAppBar.setNavigationOnClickListener {
            Toast.makeText(this, "Когда-нибудь здесь будет навигация...", Toast.LENGTH_SHORT).show()
        }

        topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.fav -> {
                    Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.search -> {
                    Toast.makeText(this, "Поиск", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.more -> {
                    Toast.makeText(this, "Еще", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

    }
}