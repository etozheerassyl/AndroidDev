package com.example.a1news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> = _posts

    init {
        _posts.value = listOf(
            Post(
                id = 1,
                title = "Новости технологий",
                content = "Сегодня представили новый крутой смартфон.",
                imageUrl = "https://picsum.photos/800/400?1"
            ),
            Post(
                id = 2,
                title = "Спорт",
                content = "Команда выиграла со счётом 3:1 в драматичном матче.",
                imageUrl = "https://picsum.photos/800/400?2"
            ),
            Post(
                id = 3,
                title = "Путешествия",
                content = "Лучшие направления для путешествий этим летом.",
                imageUrl = "https://picsum.photos/800/400?3"
            ),
            Post(
                id = 4,
                title = "Культура",
                content = "Выставка современного искусства открывается завтра.",
                imageUrl = "https://picsum.photos/800/400?4"
            )
        )
    }

    fun toggleLike(postId: Int) {
        _posts.value = _posts.value?.map {
            if (it.id == postId) it.copy(isLiked = !it.isLiked) else it
        }
    }

    fun toggleBookmark(postId: Int) {
        _posts.value = _posts.value?.map {
            if (it.id == postId) it.copy(isBookmarked = !it.isBookmarked) else it
        }
    }
}
