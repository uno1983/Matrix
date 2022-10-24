package dev.uno.Matrix

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {
    private lateinit var button: Button
    private lateinit var button1: Button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //инициализируем переменные
        button = view.findViewById(R.id.button)
        //при нажатии на кнопку, накладываем(с помощью метода add()) поверх первого фрагмент SecondFragment
        button.setOnClickListener(View.OnClickListener { view2 ->
            val transaction = parentFragmentManager.beginTransaction()
            transaction.addToBackStack("")
            transaction.add(R.id.container, SecondFragment())
            transaction.commit()
        })
            // инициализируем кнопку справа, синюю
        button1 = view.findViewById(R.id.button1)
        //при нажатии на кнопку открываем ссылку с политикой
        button1.setOnClickListener(View.OnClickListener { view2 ->
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://dzen.ru/news/rubric/politics?issue_tld=ru"))
            requireActivity().startActivity(browserIntent)
        })

    }
}