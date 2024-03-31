package com.example.finalrecyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var singerArrayList: ArrayList<Singer>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val myRecyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        var singer_names = arrayOf("1. Sidhu Moose Wala","2. Babbu Maan","3. Amrit Maan","4. Jassi Gill","5. Diljit Dosanjh","6. Jass Manak","7. Gippy Grewal",
            "8. Honey Singh","9. Guru Randhawa","10. Hardy Sandhu")

        var singer_images = arrayOf(R.drawable.sidhu1,R.drawable.maan2,R.drawable.amrit_maan3,R.drawable.jassi_gill4
        ,R.drawable.diljit5,R.drawable.jass_manak6,R.drawable.gippy7,R.drawable.honey8,R.drawable.guru_randhawa9,R.drawable.hardy10)

        var singers_about = arrayOf("The very amazing Sidhu Moose Wala secured first place on the list of top 10 Punjabi singers. Shubhdeep Singh Sidhu commonly known by his stage name Sidhu Moose Wala is a singer and songwriter; hence every song of his has hit the chart of top songs in Punjab. The songs are purely composed, written, and sung by him only. He started his career by writing the lyrics of License which was later sung by Ninja. He debuted in collaboration with Ninja on the song G Wagon. He made his way into the competitive music world and gained popularity with his track So High. Moose Wala then started to release his songs independently.\n" +
                "\n" +
                "Recently in 2021, Sidhu Moose Wala released his album named Moosetape which contains about 30 songs. The album charted on Canadian hot 100, UK Asians, and New Zealand hot charts.\n" +
                "\n" +
                "Moose Wala creates music in the genres like hip hop, Punjabi, gangsta rap, and R&B.",
            "Tejinder Babbu Maan known as Babbu Maan is a popular Indian songwriter, singer, producer, music director, and actor. Babbu Maan recorded his first album named Sajjan Rumaal De Gaya in 1997. However, most of the songs in his albums got revised and rereleased. He made his first debut in the album Tu Meri Miss India which was released in 1999. Maan has known to majorly focus and target on Punjabi audience around the world. He has released eight studio albums and six compilation albums, written screenplay, and scripts for Punjabi-produced films since 1999. He has also contributed to soundtracks in both regional and Bollywood films. Babbu Maan is also an ambassador of a non-profit organization called One Hope, One Chance which is based in Punjab. The songs of Babbu Maan are based on the genres like pop, folk, bhangra, and gazzal."
        ,"Amrit Maan is one of all-time popular in the Punjabi music industry. He has always been on top and become very popular in 2021 with his amazing songs. He is known for his amazing talent in singing, acting, and songwriting. He has sung songs like Desi Da Drum, Nakras, etc.\n" +
                    "\n" +
                    "Amrit Maan has his old style of music taste and his perfect lyrics reflect the love of Punjabi culture.\n" +
                    "\n" +
                    "Amrit Maan has started his career by his writing his first song Jatt Fire Karda which was later sung by Diljit Dosanjh. The song was immensely praised by the audience and his career got Kick-started from that very moment. Eventually, he got applauded for his singing and acting talent. He started his career with the song Much Te Mashook and the song became a blockbuster. Amrit Maan has always been in the talk for his unique beard look and singing talent. He is one of the most eligible bachelors, any girl can dream of."
        ,"Jassi Gill has been the dream boy for many girls as he has earned the first position for the most desirable men in Chandigarh Times and placed at number 42 in the Times Most Desirable Men. He mostly works on genres like bhangra, romance, and pop. No doubt he is one of the most popular male Punjabi singers in this trendy world of music.\n" +
                    "\n" +
                    "The lyrics of the songs are written so thoughtfully that they can lighten your mood and at the same time give you party vibes.\n" +
                    "\n" +
                    "Lamborghini, Nikle Current, Guitar Sikhda, Bapu Zimidar, Aukat, Allah Ve, Dill Ton Black, Dil Tutda, Laden, Yaar Jatt De, Tru Talk, Gabbroo, Surma Kaala, and many more are his popular tracks that ruled the heart of Punjabi music lovers.\n" +
                    "\n" +
                    "Jassi Gill made his debut in the song Batchmate in the year 2011 and gained popularity in 2013 from the song Lancer. The song Lancer received 3 million views on YouTube."
        ,"Diljit Dosanjh is a talented young man born on January 6, 1984. He is a singer, actor, and producer who have debuted in Punjabi as well as Hindi Bollywood films. His music is based on the genres like Punjabi, Bhangra, romantic, pop, and hip-hop party songs. He has attracted wide attention with his acting and made an unshakable place in Hindi cinema. He became popular by giving movies like Udta Punjab, Good News, Honsla Rakh, and many more. He earned Filmfare award for the best male debut. He is the first Punjabi singer to make his way into Hindi cinema smoothly and became famous for what he does. Diljit Dosanjh peaked in the chart of Social 50 by Billboard."
        ,"Jass Manak is a pure soul of bubbly, hip hop, cool nature. He is a singer and songwriter. He debuted in the song U-turn in 2017 and gained huge appreciation. Jass' incredible tracks include Prada, Lehnga, Suit Punjabi, Boss, etc. The release of Lehnga was a huge hit for his career as the song reached the international level of UK Asian Music Charts and Global Indian YouTube. Jass Manak was also featured to be the most listened to artist in Punjab on YouTube. He sings in the genres like pop, romantic, and bhangra."
        ,"Rupinder Singh Gippy Grewal is a popular Punjabi actor, singer, director, and producer in both Punjabi and Hindi cinemas. His single Phulkari was a huge hit in the Punjabi music industry. Gippy debuted in Bollywood in 2010. His acting career got a swing since his debut film Mel Karada Rabba and from then he has shown his acting skills in many other great movies. He won PIFAA Best Actor Award in 2012 for the movie Jatt James Bond. He shared the award with Diljit Dosanjh."
        ,"Hirdesh Singh known by his stage name Yo Yo Honey Singh or simply Honey Singh is a rapper, composer, pop vocalist, and actor. Honey Singh has an era of his songs where youth and children were extremely fond of him. His very song became a huge success in those years when no other singer could stand a chance in front of Honey Singh.\n" +
                    "\n" +
                    "He started his career as a recording artist which later turned into a bhangra music composer. He soon began to make music for Bollywood films. In today's time, he is one of the highest-paid singers in the Indian Music Industry.\n" +
                    "\n" +
                    "But there was a time in 2014 when Honey Singh suddenly vanished from the music industry due to his medical condition bipolar issue, thus he rebounded in the next year but things were different for him then. He confessed his bipolar situation in March 2016.\n" +
                    "\n" +
                    "Honey Singh sings in Hindi and Punjabi languages in combination with English rap. Some of the golden songs of Honey Singhare Blue Eyes, Break Up Party, Lungi Dance, One Bottle Down, Party All Night, and many more."
        ,"Guru Randhawa secured second place for most popular Punjabi Singers in 2021. Guru Randhawa is a singer, songwriter, actor, and producer. His soothing voice and his Punjabi accent give life to music. The audience loves his exceptional songwriting skills and composition of music. His amazing party and dance numbers are rewards for the audience. He is a gem for his killer looks and cute smile."
            ,"Hardevinder Singh Sandhu popularly known as Hardy Sandhu is an Indian singer, actor, and ex-cricketer. He got attention for his amazing singing in the songs Soch and Joker which was written by Jaani. He started his career by making his debut in the song Tequilla Shot.\n" +
                    "\n" +
                    "Hardy is a fabulous singer as well as an amazing actor. For his acting skills, he got praised for the movie Yaaran Da Katchup.\n" +
                    "\n" +
                    "Some songs of Hardy will be evergreen hits, which include Joker, Backbone, Horn Blow, Yaar Na Mileya. He made a duet song titled Naah with beautiful Nora Fatehi in 2017 which became the nation's biggest hit of that year. He became a national singing sensation with his biggest hits songs like Naah and Kya Baat Aye. Now he is also regarded as one of the most popular singers of Punjab in 2021.\n" +
                    "\n" +
                    "He works on the genres like jazz, pop, hip hop, Indian and classical Punjabi. He is also a part of the recent movie '83' based on the 1983 World Cup Championship. The movie is surely special to him as he is a former cricketer too."

        )

        singerArrayList = ArrayList<Singer>()

        for (index in singer_names.indices){
            var singer = Singer(singer_images[index],singer_names[index],singers_about[index])
            singerArrayList.add(singer)
        }

        myRecyclerView.layoutManager = LinearLayoutManager(this)

        var myAdaper = MyAdapter(this,singerArrayList)

        myRecyclerView.adapter  = myAdaper

        myAdaper.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onClick(position: Int) {

                Toast.makeText(this@MainActivity,"Working",Toast.LENGTH_SHORT).show()


                val intent = Intent(this@MainActivity,Singers_Details::class.java)

                intent.putExtra("name",singerArrayList[position].singer_name)
                intent.putExtra("image",singerArrayList[position].singer_image)
                intent.putExtra("about",singerArrayList[position].singer_about)
                startActivity(intent)

            }

        })

    }
}