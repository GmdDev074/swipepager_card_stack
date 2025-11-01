# 🎯 SwipePager – Swipeable Quiz / Question Cards (Android)

A modern swipeable card UI built using **ViewPager2** with smooth transitions, card scaling animation, and controlled swipe gestures.  
Designed for fun Q&A interactions — perfect for quizzes, surveys, and onboarding flows!

---

## ✨ Features

✅ Swipe left/right to navigate between questions  
✅ Card scaling + shadow elevation animations  
✅ Snap-back behavior on vertical free-fall swipes  
✅ Smooth transitions using `CompositePageTransformer`  
✅ Data-driven questions using Kotlin data class  
✅ Lightweight + Easy to customize UI  
✅ No card removal on swipe — safe navigation  

---

## 🧩 Tech Stack

- **Kotlin**
- **ViewPager2**
- **RecyclerView**
- **ItemTouchHelper** for swipe behavior
- **Material Components**
- XML Layout UI

---

## 📂 Project Structure
```bash
com.zatswahm.swipepager/
│
├── data/
│ └── Question.kt
│
├── ui/adapter/
│ └── QuestionAdapter.kt
│
├── ui/main/
│ ├── MainActivity.kt
│ └── SwipeTouchHelper.kt
│
└── res/layout/
├── activity_main.xml
└── item_question.xml
```


---

## 🚀 How to Use

1️⃣ Clone the repo  
```bash
git clone https://github.com/GmdDev074/swipepager_card_stack
```

2️⃣ Open project in Android Studio

3️⃣ Sync Gradle dependencies

4️⃣ Run on a device/emulator ✅

🛠 Customization

Modify questions list inside setupData()

Update UI in item_question.xml

Adjust card animations inside MainActivity.kt

Add network support for dynamic questions

✅ Upcoming Enhancements (Planned)

✅ Add smooth spring animation on snap-back

🔄 Dynamic question API support

🏆 Quiz scoring & progress indicator

🎨 More beautiful card themes + dark mode

---

🤝 Contributing

Pull requests are welcome!
If you'd like major enhancements, please open an issue first to discuss what you'd like to change.

---

👤 Author

Developed by GMD Android
Feel free to star ⭐ the repo if you found it useful!

---

📄 License

This project is open-sourced under the MIT License.
