package com.zatswahm.swipepager.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.zatswahm.swipepager.data.Question
import com.zatswahm.swipepager.databinding.ActivityMainBinding
import com.zatswahm.swipepager.ui.adapter.QuestionAdapter
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: QuestionAdapter
    private val questions = mutableListOf<Question>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupData()
        setupViewPager()
    }

    private fun setupData() {
        questions.add(
            Question(
                "Which programming language do you prefer for Android development?",
                listOf("Kotlin", "Java", "Both")
            )
        )
        questions.add(
            Question(
                "Tabs or spaces for indentation?",
                listOf("Tabs", "Spaces", "Doesn’t matter")
            )
        )
        questions.add(
            Question(
                "Favorite version control platform?",
                listOf("GitHub", "GitLab", "Bitbucket")
            )
        )
        questions.add(
            Question(
                "Dark theme or light theme while coding?",
                listOf("Dark Theme", "Light Theme", "Auto")
            )
        )
        questions.add(
            Question(
                "Your go-to mobile database?",
                listOf("Room", "Realm", "Firebase")
            )
        )
        questions.add(
            Question(
                "Preferred app architecture pattern?",
                listOf("MVVM", "MVP", "MVI")
            )
        )
        questions.add(
            Question(
                "Do you like using Jetpack Compose?",
                listOf("Love it!", "Still learning", "Prefer XML")
            )
        )
        questions.add(
            Question(
                "How often do you refactor your code?",
                listOf("Frequently", "Sometimes", "Rarely")
            )
        )
        questions.add(
            Question(
                "Which testing approach do you follow?",
                listOf("Unit Tests", "UI Tests", "Both")
            )
        )
        questions.add(
            Question(
                "Preferred backend for mobile apps?",
                listOf("Firebase", "Node.js", "Spring Boot")
            )
        )
    }

    private fun setupViewPager() {
        adapter = QuestionAdapter(questions)
        binding.viewPager.adapter = adapter

        // Dynamically set offscreenPageLimit for efficiency
        val dynamicLimit = max(1, min(3, questions.size / 2))
        binding.viewPager.offscreenPageLimit = dynamicLimit

        binding.viewPager.apply {
            clipChildren = false
            clipToPadding = false
            getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        }

        val density = resources.displayMetrics.density

        val transformer = CompositePageTransformer().apply {
            addTransformer(MarginPageTransformer(10))
            addTransformer { page, position ->
                val absPos = abs(position)
                val scale = 0.85f + (1 - absPos) * 0.15f
                page.scaleY = scale
                page.scaleX = scale
                page.alpha = 0.4f + (1 - absPos) * 0.6f
                page.translationX = -position * page.width * 0.15f  // Increased for more overlap/peeking
                page.elevation = (1 - absPos) * 28 * density  // Dynamic elevation for "elevated on them" effect with shadows
            }
        }

        binding.viewPager.setPageTransformer(transformer)

        val rv = binding.viewPager.getChildAt(0) as RecyclerView

        // Fix stacking/overlapping by adjusting child drawing order (center on top)
        rv.setChildDrawingOrderCallback { childCount, i ->
            if (childCount == 0) return@setChildDrawingOrderCallback i

            val positions = (0 until childCount).map { rv.getChildAdapterPosition(rv.getChildAt(it)) }
            val current = binding.viewPager.currentItem
            // Sort child indices by descending distance from current (farthest drawn first/bottom)
            val sortedIndices = (0 until childCount).sortedBy { abs(positions[it] - current) }.reversed()
            sortedIndices[i]
        }

        // ✅ Keep swipe → but DO NOT remove card anymore
        val helper = ItemTouchHelper(SwipeTouchHelper { position ->
            val next = (binding.viewPager.currentItem + 1).coerceAtMost(adapter.itemCount - 1)
            binding.viewPager.setCurrentItem(next, true)
        })
        helper.attachToRecyclerView(rv)
    }
}