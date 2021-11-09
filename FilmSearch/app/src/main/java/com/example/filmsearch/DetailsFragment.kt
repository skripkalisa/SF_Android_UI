package com.example.filmsearch

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton


class DetailsFragment : Fragment() {
    private lateinit var film: Film

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val detailsFabFavorites = binding.detailsFabFavorites
//        val detailsFabShare = binding.detailsFabShare
        val detailsFabFavorites = view.findViewById<FloatingActionButton>(R.id.details_fab_favorites)
        val detailsFabShare = view.findViewById<FloatingActionButton>(R.id.details_fab_share)

        film = setFilmsDetails()

       if(::film.isInitialized) {
           println("initialized")
        }
            detailsFabFavorites.setOnClickListener {
                if (!film.isInFavorites) {
                    detailsFabFavorites.setImageResource(R.drawable.ic_baseline_favorite_24)
                    film.isInFavorites = true
                } else {
                    detailsFabFavorites.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                    film.isInFavorites = false
                }
            }
            detailsFabShare.setOnClickListener {
                //Создаем интент
                val intent = Intent()
                //Указываем action с которым он запускается
                intent.action = Intent.ACTION_SEND
                //Кладем данные о нашем фильме
                intent.putExtra(
                    Intent.EXTRA_TEXT,
                    "Check out this film: ${film.title} \n\n ${film.description}"
                )
                //Указываем MIME тип, чтобы система знала, какое приложения предложить
                intent.type = "text/plain"
                //Запускаем наше активити
                startActivity(Intent.createChooser(intent, "Share To:"))
            }
    }

    private fun setFilmsDetails() :Film{
//    lateinit var binding: FragmentDetailsBinding

        val detailsFabFavorites = view?.findViewById<FloatingActionButton>(R.id.details_fab_favorites)
        val detailsToolbar = view?.findViewById<androidx.appcompat.widget.Toolbar>(R.id.details_toolbar)
        val detailsPoster = view?.findViewById<ImageView>(R.id.details_poster)
        val detailsDescription = view?.findViewById<TextView>(R.id.details_description)

//        val detailsToolbar = binding.detailsToolbar
//        val detailsPoster = binding.detailsPoster
//        val detailsDescription = binding.detailsDescription
//        val detailsFabFavorites = binding.detailsFabFavorites

        //Получаем наш фильм из переданного бандла
        val film = arguments?.get("film") as Film

        //Устанавливаем заголовок
        detailsToolbar?.title = film.title
        //Устанавливаем картинку
        detailsPoster?.setImageResource(film.poster)
        //Устанавливаем описание
        detailsDescription?.text = film.description

        detailsFabFavorites?.setImageResource(
            if (film.isInFavorites) R.drawable.ic_baseline_favorite_24
            else R.drawable.ic_baseline_favorite_border_24
        )
        return film
    }
}