package dev.uno.Matrix

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycleView)
        button = view.findViewById(R.id.button)
        var list = mutableListOf<ModelRV>() //список куда будут класться элементы для RecycleView
        list.add(
            ModelRV(
                path = "https://trudvsem.ru/educational-programs?_title=android&page=0&titleType=COURSE_NAME&categories=UNEMPLOYED_REGISTERED",
                name = "записаться на курсы проекта Содействие занятости"
            )
        )

        list.add(
            ModelRV(
                path = "https://zoom.us/",
                name = "используя систему видеоконференцсвязи ZOOM"
            )
        )
        list.add(
            ModelRV(
                path = "https://developer.android.com/studio",
                name = "выполняя практические задания в Android Studio"
            )
        )
        list.add(
            ModelRV(
                path = "https://odin.study/",
                name = "пройти онлайн-обучение на портале Один"
            )
        )
        recyclerView.layoutManager = LinearLayoutManager(context)
        //присваем адаптер к  recyclerview
        recyclerView.adapter = Adapter(context = requireContext(), list, this)
        //при нажатии на кнопку накладываем на второй фрагмент ThirdFragment
        button.setOnClickListener(View.OnClickListener { view2 ->
            val transaction = parentFragmentManager.beginTransaction()
            transaction.addToBackStack("")
            transaction.add(R.id.container, ThirdFragment())
            transaction.commit()
        })
    }

}