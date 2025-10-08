package com.example.a1news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.a1news.databinding.ItemPostBinding

class PostAdapter(
    private var posts: List<Post>,
    private val onLikeClick: (Int) -> Unit,
    private val onBookmarkClick: (Int) -> Unit
) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) {
            binding.postTitle.text = post.title
            binding.postContent.text = post.content

            binding.postImage.load(post.imageUrl) {
                crossfade(true)
                placeholder(android.R.drawable.ic_menu_report_image)
                error(android.R.drawable.stat_notify_error)
            }

            binding.likeButton.setImageResource(
                if (post.isLiked) R.drawable.ic_heart_filled else R.drawable.ic_heart_outline
            )
            binding.bookmarkButton.setImageResource(
                if (post.isBookmarked) R.drawable.ic_bookmark_filled else R.drawable.ic_bookmark_outline
            )

            binding.likeButton.setOnClickListener { onLikeClick(post.id) }
            binding.bookmarkButton.setOnClickListener { onBookmarkClick(post.id) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount(): Int = posts.size

    fun updatePosts(newPosts: List<Post>) {
        posts = newPosts
        notifyDataSetChanged()
    }
}
