package com.prepmaster.app.data.content

import com.prepmaster.app.data.model.QuizQuestion
import com.prepmaster.app.data.model.PracticeItem
import com.prepmaster.app.data.model.StoryItem
import com.prepmaster.app.data.model.StoryQuestion

val allQuizQuestions = listOf(
    // ── PLACE (q1–q20) ────────────────────────────────────────────────
    QuizQuestion("q1","The ball is ___ the box.",listOf("in","on","at","under"),0,"'In' মানে ভেতরে (enclosed space)।","place"),
    QuizQuestion("q2","The book is ___ the table.",listOf("in","over","on","at"),2,"'On' মানে উপরে (surface contact)।","place"),
    QuizQuestion("q3","She is waiting ___ the bus stop.",listOf("in","at","on","by"),1,"নির্দিষ্ট বিন্দু = at।","place"),
    QuizQuestion("q4","The cat is hiding ___ the sofa.",listOf("over","above","behind","in front of"),2,"'Behind' = পেছনে।","place"),
    QuizQuestion("q5","The park is ___ the school and the hospital.",listOf("among","between","beside","near"),1,"দুটির মাঝে = between।","place"),
    QuizQuestion("q6","She sat ___ the window.",listOf("in","on","by","at"),2,"'By' = পাশে।","place"),
    QuizQuestion("q7","The temperature is ___ 40 degrees.",listOf("on","over","above","up"),2,"স্পর্শ ছাড়া উপরে = above।","place"),
    QuizQuestion("q8","He stood ___ the door.",listOf("in","at","on","by"),1,"নির্দিষ্ট বিন্দু = at।","place"),
    QuizQuestion("q9","The fish swim ___ the surface.",listOf("under","below","beneath","down"),1,"স্পর্শ ছাড়া নিচে = below।","place"),
    QuizQuestion("q10","She lives ___ the building opposite ours.",listOf("in","at","inside","opposite"),3,"বিপরীত = opposite।","place"),
    QuizQuestion("q11","Many fish live ___ the sea.",listOf("at","in","on","under"),1,"বড় জায়গার ভেতরে = in।","place"),
    QuizQuestion("q12","The picture is hanging ___ the wall.",listOf("in","at","on","by"),2,"Surface = on।","place"),
    QuizQuestion("q13","She is standing ___ the corner.",listOf("in","at","on","by"),1,"Corner = specific point = at।","place"),
    QuizQuestion("q14","The bird is ___ the tree.",listOf("in","on","at","above"),0,"ভেতরে/শাখায় = in।","place"),
    QuizQuestion("q15","He is sitting ___ two tall people.",listOf("between","among","beside","near"),0,"দুজনের মাঝে = between।","place"),
    QuizQuestion("q16","She is popular ___ her friends.",listOf("between","among","beside","within"),1,"অনেকের মধ্যে = among।","place"),
    QuizQuestion("q17","The river flows ___ the city.",listOf("across","through","along","over"),1,"শহরের মধ্য দিয়ে = through।","place"),
    QuizQuestion("q18","The bridge is ___ the river.",listOf("above","over","across","on"),1,"সরাসরি উপরে (কভার) = over।","place"),
    QuizQuestion("q19","She hid the key ___ the mat.",listOf("below","under","beneath","in"),1,"সরাসরি নিচে = under।","place"),
    QuizQuestion("q20","He lives ___ the third floor.",listOf("in","at","on","by"),2,"Floor/surface = on।","place"),

    // ── TIME (q21–q40) ─────────────────────────────────────────────────
    QuizQuestion("q21","The class starts ___ 9 AM.",listOf("in","on","at","by"),2,"নির্দিষ্ট সময় = at।","time"),
    QuizQuestion("q22","She was born ___ March.",listOf("at","on","in","by"),2,"মাস = in।","time"),
    QuizQuestion("q23","We met ___ Monday.",listOf("in","at","on","by"),2,"দিন = on।","time"),
    QuizQuestion("q24","He has lived here ___ 2015.",listOf("for","since","from","until"),1,"নির্দিষ্ট point থেকে = since।","time"),
    QuizQuestion("q25","I studied ___ two hours.",listOf("since","for","during","within"),1,"Duration = for।","time"),
    QuizQuestion("q26","Submit the form ___ Friday.",listOf("until","by","before","on"),1,"Deadline = by।","time"),
    QuizQuestion("q27","Don't talk ___ the exam.",listOf("during","for","while","in"),0,"Period এর মধ্যে = during।","time"),
    QuizQuestion("q28","The office is open ___ 9 ___ 5.",listOf("from...to","since...till","at...at","in...in"),0,"শুরু থেকে শেষ = from…to।","time"),
    QuizQuestion("q29","I'll call you ___ an hour.",listOf("within","in","for","by"),0,"সময়ের ভেতরে = within।","time"),
    QuizQuestion("q30","Wash your hands ___ eating.",listOf("after","before","during","while"),1,"আগে = before।","time"),
    QuizQuestion("q31","She has been studying ___ morning.",listOf("since","for","from","during"),0,"Since this morning।","time"),
    QuizQuestion("q32","I haven't seen him ___ last week.",listOf("since","for","from","in"),0,"Specific past point = since।","time"),
    QuizQuestion("q33","She waited ___ an hour but he didn't come.",listOf("since","for","during","within"),1,"Duration = for।","time"),
    QuizQuestion("q34","Please come back ___ 6 PM.",listOf("by","until","before","on"),0,"Not later than = by।","time"),
    QuizQuestion("q35","The shop is open ___ 9 AM to 9 PM.",listOf("from","since","at","in"),0,"Starting point = from।","time"),
    QuizQuestion("q36","She worked ___ the whole night.",listOf("during","for","throughout","within"),2,"The entire period = throughout।","time"),
    QuizQuestion("q37","The meeting is ___ the 5th of June.",listOf("in","at","on","by"),2,"Date = on।","time"),
    QuizQuestion("q38","I was born ___ the 1990s.",listOf("at","on","in","during"),2,"Decade = in।","time"),
    QuizQuestion("q39","She'll return ___ Christmas.",listOf("on","at","in","by"),1,"Festival = at।","time"),
    QuizQuestion("q40","He finished the project ___ time.",listOf("in","on","at","by"),0,"Expected time = in time।","time"),

    // ── MOVEMENT (q41–q56) ─────────────────────────────────────────────
    QuizQuestion("q41","She went ___ school.",listOf("to","at","in","into"),0,"গন্তব্য = to।","movement"),
    QuizQuestion("q42","The cat jumped ___ the table.",listOf("on","onto","over","above"),1,"Surface এ উঠে গেল = onto।","movement"),
    QuizQuestion("q43","She walked ___ the park.",listOf("across","through","along","over"),1,"মধ্য দিয়ে = through।","movement"),
    QuizQuestion("q44","He ran ___ the road.",listOf("through","along","across","over"),2,"পার হয়ে = across।","movement"),
    QuizQuestion("q45","She climbed ___ the mountain.",listOf("up","on","over","onto"),0,"উপরের দিকে = up।","movement"),
    QuizQuestion("q46","The ball rolled ___ the hill.",listOf("up","down","along","across"),1,"নিচের দিকে = down।","movement"),
    QuizQuestion("q47","She moved ___ the door.",listOf("toward","to","into","at"),0,"দিকে = toward।","movement"),
    QuizQuestion("q48","Get ___ the bus here.",listOf("off","out","down","from"),0,"নামা = off।","movement"),
    QuizQuestion("q49","She came ___ Chittagong.",listOf("to","from","out of","in"),1,"উৎস = from।","movement"),
    QuizQuestion("q50","She walked ___ the beach.",listOf("along","across","through","over"),0,"বরাবর = along।","movement"),
    QuizQuestion("q51","She walked ___ the room and greeted everyone.",listOf("into","in","to","onto"),0,"ভেতরে প্রবেশ = into।","movement"),
    QuizQuestion("q52","He drove ___ the tunnel.",listOf("across","through","over","along"),1,"টানেলের মধ্য দিয়ে = through।","movement"),
    QuizQuestion("q53","The bird flew ___ the window.",listOf("through","past","over","across"),1,"Past the window = past।","movement"),
    QuizQuestion("q54","She moved ___ the corner to hide.",listOf("behind","around","along","past"),1,"Corner ঘুরে = around।","movement"),
    QuizQuestion("q55","He took the key ___ his pocket.",listOf("from","out of","in","off"),1,"Out of pocket = out of।","movement"),
    QuizQuestion("q56","She swam ___ the river.",listOf("along","across","through","over"),1,"পার হয়ে = across।","movement"),

    // ── MANNER (q57–q64) ──────────────────────────────────────────────
    QuizQuestion("q57","She wrote ___ a pen.",listOf("by","with","using","through"),1,"Instrument = with।","manner"),
    QuizQuestion("q58","She traveled ___ train.",listOf("with","by","on","in"),1,"Transport = by।","manner"),
    QuizQuestion("q59","She sings ___ a nightingale.",listOf("as","like","with","by"),1,"Comparison = like।","manner"),
    QuizQuestion("q60","She works ___ a doctor.",listOf("like","as","by","with"),1,"Role = as।","manner"),
    QuizQuestion("q61","Don't go ___ permission.",listOf("with","by","without","from"),2,"Absence = without।","manner"),
    QuizQuestion("q62","He spoke ___ confidence.",listOf("in","with","by","of"),1,"Manner = with।","manner"),
    QuizQuestion("q63","She learned English ___ watching movies.",listOf("with","by","through","from"),1,"Method = by।","manner"),
    QuizQuestion("q64","He solved the problem ___ hard work.",listOf("through","with","by","in"),0,"Channel/means = through।","manner"),

    // ── CAUSE (q65–q72) ───────────────────────────────────────────────
    QuizQuestion("q65","The match was canceled ___ rain.",listOf("due to","because","for","by"),0,"Noun এর আগে কারণ = due to।","cause"),
    QuizQuestion("q66","She is famous ___ her singing.",listOf("by","with","for","of"),2,"Reason = for।","cause"),
    QuizQuestion("q67","She did it ___ kindness.",listOf("from","with","out of","by"),2,"Emotion = out of।","cause"),
    QuizQuestion("q68","He is suffering ___ fever.",listOf("of","with","from","by"),2,"suffer from।","cause"),
    QuizQuestion("q69","He failed ___ laziness.",listOf("because","due to","for","by"),1,"Formal cause = due to।","cause"),
    QuizQuestion("q70","She wept ___ joy.",listOf("with","from","out of","for"),2,"Emotion = out of।","cause"),
    QuizQuestion("q71","He was rewarded ___ his bravery.",listOf("by","for","with","of"),1,"Reason for reward = for।","cause"),
    QuizQuestion("q72","Many died ___ hunger.",listOf("of","from","with","due to"),1,"die from = from।","cause"),

    // ── AGENT (q73–q78) ───────────────────────────────────────────────
    QuizQuestion("q73","The book was written ___ Tagore.",listOf("with","by","from","of"),1,"Passive: agent = by।","agent"),
    QuizQuestion("q74","The letter was written ___ a pen.",listOf("by","with","using","on"),1,"Instrument = with।","agent"),
    QuizQuestion("q75","She talked ___ the phone.",listOf("in","by","on","with"),2,"Device = on।","agent"),
    QuizQuestion("q76","The house was destroyed ___ fire.",listOf("with","by","from","of"),1,"Passive cause/agent = by।","agent"),
    QuizQuestion("q77","She sent the message ___ email.",listOf("by","through","with","on"),1,"Channel = through।","agent"),
    QuizQuestion("q78","It was done ___ a machine.",listOf("by","with","through","using"),0,"Passive agent = by।","agent"),

    // ── POSSESSION (q79–q82) ──────────────────────────────────────────
    QuizQuestion("q79","The capital ___ Bangladesh is Dhaka.",listOf("of","for","in","at"),0,"Possession/relation = of।","possession"),
    QuizQuestion("q80","He is kind ___ everyone.",listOf("of","for","to","with"),2,"Relation = to।","possession"),
    QuizQuestion("q81","The roof ___ the house is damaged.",listOf("of","in","at","from"),0,"Part = of।","possession"),
    QuizQuestion("q82","She is proud ___ her son.",listOf("of","for","about","with"),0,"proud of।","possession"),

    // ── SOURCE (q83–q86) ──────────────────────────────────────────────
    QuizQuestion("q83","She is ___ Bangladesh.",listOf("of","from","in","at"),1,"Origin = from।","source"),
    QuizQuestion("q84","The table is made ___ wood.",listOf("of","from","by","with"),0,"Material = made of।","source"),
    QuizQuestion("q85","Water comes ___ the tap.",listOf("from","out of","through","in"),1,"Emerging from = out of।","source"),
    QuizQuestion("q86","He learned it ___ his teacher.",listOf("from","by","with","through"),0,"Source of learning = from।","source"),

    // ── COMPOUND (q87–q100) ───────────────────────────────────────────
    QuizQuestion("q87","She succeeded ___ difficulties.",listOf("in spite of","despite of","because of","in case of"),0,"সত্ত্বেও = in spite of।","compound"),
    QuizQuestion("q88","She drank juice ___ tea.",listOf("instead of","in place","rather","without"),0,"পরিবর্তে = instead of।","compound"),
    QuizQuestion("q89","___ the report, it will rain.",listOf("According to","Due to","In case of","By means of"),0,"অনুযায়ী = according to।","compound"),
    QuizQuestion("q90","___ fire, use the stairs.",listOf("In spite of","In case of","Instead of","On top of"),1,"পরিস্থিতিতে = in case of।","compound"),
    QuizQuestion("q91","He spoke ___ the team.",listOf("on behalf of","instead of","in front of","according to"),0,"পক্ষ থেকে = on behalf of।","compound"),
    QuizQuestion("q92","She stood ___ the class.",listOf("in front of","in case of","instead of","on top of"),0,"সামনে = in front of।","compound"),
    QuizQuestion("q93","___ English, she knows Bengali.",listOf("In addition to","Instead of","According to","In front of"),0,"ছাড়াও = in addition to।","compound"),
    QuizQuestion("q94","He escaped ___ a rope.",listOf("by means of","instead of","in case of","in spite of"),0,"মাধ্যমে = by means of।","compound"),
    QuizQuestion("q95","___ her tiredness, she kept working.",listOf("Despite","Although","Because of","In case of"),0,"সত্ত্বেও = despite।","compound"),
    QuizQuestion("q96","The snow was ___ the roof.",listOf("on top of","in front of","instead of","according to"),0,"একদম উপরে = on top of।","compound"),
    QuizQuestion("q97","___ these facts, our plan needs change.",listOf("In view of","In spite of","In case of","Instead of"),0,"এই তথ্যের পরিপ্রেক্ষিতে = in view of।","compound"),
    QuizQuestion("q98","___ the storm, the match was canceled.",listOf("Owing to","In spite of","Instead of","According to"),0,"কারণে (formal) = owing to।","compound"),
    QuizQuestion("q99","She communicated ___ sign language.",listOf("by means of","instead of","in spite of","in case of"),0,"মাধ্যমে = by means of।","compound"),
    QuizQuestion("q100","___ your last email, the meeting is confirmed.",listOf("With reference to","In spite of","Instead of","On top of"),0,"সম্পর্কে/অনুযায়ী = with reference to।","compound"),
)

val allPracticeItems = listOf(
    // PLACE
    PracticeItem("p1","The cat is ___ the box.","in",listOf("in","on","at","under"),"বিড়ালটি বাক্সের ভেতরে।","বন্ধ স্থান = in।","place"),
    PracticeItem("p2","The book is ___ the table.","on",listOf("in","on","at","over"),"বইটি টেবিলের উপরে।","surface = on।","place"),
    PracticeItem("p3","She is ___ the bus stop.","at",listOf("in","at","on","by"),"বাস স্টপে।","নির্দিষ্ট বিন্দু = at।","place"),
    PracticeItem("p4","He sat ___ her.","beside",listOf("beside","behind","near","next to"),"পাশে বসল।","পাশে = beside।","place"),
    PracticeItem("p5","The park is ___ the school and the hospital.","between",listOf("between","among","beside","near"),"পার্কটি মাঝে।","দুটির মাঝে = between।","place"),
    PracticeItem("p6","The bird is sitting ___ the tree.","in",listOf("on","in","at","above"),"গাছে।","ভেতরে/শাখায় = in।","place"),
    PracticeItem("p7","There is a painting ___ the wall.","on",listOf("on","in","at","beside"),"দেয়ালে।","Surface = on।","place"),
    PracticeItem("p8","She is popular ___ her classmates.","among",listOf("between","among","beside","near"),"সহপাঠীদের মধ্যে।","অনেকের মধ্যে = among।","place"),
    PracticeItem("p9","He lives ___ the third floor.","on",listOf("in","at","on","by"),"তৃতীয় তলায়।","floor = on।","place"),
    PracticeItem("p10","The river flows ___ the city.","through",listOf("across","through","along","over"),"শহরের মধ্য দিয়ে।","inside through = through।","place"),
    // TIME
    PracticeItem("p11","The class starts ___ 9 AM.","at",listOf("at","in","on","by"),"৯টায় শুরু।","নির্দিষ্ট সময় = at।","time"),
    PracticeItem("p12","She was born ___ March.","in",listOf("at","on","in","by"),"মার্চে।","মাস = in।","time"),
    PracticeItem("p13","We met ___ Monday.","on",listOf("in","at","on","by"),"সোমবারে।","দিন = on।","time"),
    PracticeItem("p14","He has lived here ___ 2015.","since",listOf("for","since","from","until"),"২০১৫ থেকে।","since।","time"),
    PracticeItem("p15","I studied ___ two hours.","for",listOf("since","for","during","within"),"দুই ঘণ্টা।","duration = for।","time"),
    PracticeItem("p16","Don't talk ___ the exam.","during",listOf("during","for","while","in"),"পরীক্ষার সময়।","period = during।","time"),
    PracticeItem("p17","Submit the form ___ Friday.","by",listOf("until","by","before","on"),"শুক্রবারের মধ্যে।","deadline = by।","time"),
    PracticeItem("p18","She has been studying ___ morning.","since",listOf("for","since","from","during"),"সকাল থেকে।","since।","time"),
    PracticeItem("p19","She worked ___ the whole night.","throughout",listOf("during","for","throughout","within"),"পুরো রাত ধরে।","entire period = throughout।","time"),
    PracticeItem("p20","He finished ___ time.","in",listOf("in","on","at","by"),"সময়মতো।","in time।","time"),
    // MOVEMENT
    PracticeItem("p21","She went ___ school early.","to",listOf("to","at","in","into"),"স্কুলে গেল।","গন্তব্য = to।","movement"),
    PracticeItem("p22","She walked ___ the park.","through",listOf("across","through","along","over"),"পার্কের মধ্য দিয়ে।","through।","movement"),
    PracticeItem("p23","He ran ___ the road.","across",listOf("through","along","across","over"),"রাস্তা পার।","across।","movement"),
    PracticeItem("p24","She climbed ___ the stairs.","up",listOf("up","on","over","onto"),"উপরে উঠল।","up।","movement"),
    PracticeItem("p25","She walked ___ the room.","into",listOf("into","in","to","onto"),"ঘরে ঢুকল।","into।","movement"),
    PracticeItem("p26","The cat jumped ___ the table.","onto",listOf("on","onto","over","above"),"টেবিলে উঠল।","onto।","movement"),
    PracticeItem("p27","She swam ___ the river.","across",listOf("along","across","through","over"),"নদী পার।","across।","movement"),
    PracticeItem("p28","She walked ___ the beach.","along",listOf("along","across","through","over"),"সমুদ্র সৈকত বরাবর।","along।","movement"),
    // MANNER
    PracticeItem("p29","She wrote ___ a pen.","with",listOf("by","with","using","through"),"কলম দিয়ে।","instrument = with।","manner"),
    PracticeItem("p30","She traveled ___ train.","by",listOf("with","by","on","in"),"ট্রেনে।","transport = by।","manner"),
    PracticeItem("p31","She sings ___ a nightingale.","like",listOf("as","like","with","by"),"বুলবুলির মতো।","comparison = like।","manner"),
    PracticeItem("p32","She works ___ a doctor.","as",listOf("like","as","by","with"),"ডাক্তার হিসেবে।","role = as।","manner"),
    PracticeItem("p33","Don't go ___ permission.","without",listOf("with","by","without","from"),"অনুমতি ছাড়া।","without।","manner"),
    // CAUSE
    PracticeItem("p34","The match was canceled ___ rain.","because of",listOf("due to","because of","for","by"),"বৃষ্টির কারণে।","cause।","cause"),
    PracticeItem("p35","The flight was delayed ___ fog.","due to",listOf("because of","due to","for","by"),"কুয়াশার কারণে।","formal = due to।","cause"),
    PracticeItem("p36","She is famous ___ her singing.","for",listOf("by","with","for","of"),"গানের জন্য বিখ্যাত।","reason = for।","cause"),
    PracticeItem("p37","He is suffering ___ fever.","from",listOf("of","with","from","by"),"জ্বরে ভুগছে।","suffer from।","cause"),
    // AGENT
    PracticeItem("p38","The book was written ___ Tagore.","by",listOf("with","by","from","of"),"রবীন্দ্রনাথ।","passive agent = by।","agent"),
    PracticeItem("p39","She talked ___ the phone.","on",listOf("in","by","on","with"),"ফোনে।","device = on।","agent"),
    // POSSESSION
    PracticeItem("p40","The capital ___ Bangladesh is Dhaka.","of",listOf("of","for","in","at"),"বাংলাদেশের রাজধানী।","of।","possession"),
    PracticeItem("p41","She is proud ___ her son.","of",listOf("of","for","about","with"),"ছেলের জন্য গর্বিত।","proud of।","possession"),
    // SOURCE
    PracticeItem("p42","She is ___ Bangladesh.","from",listOf("of","from","in","at"),"বাংলাদেশ থেকে।","origin = from।","source"),
    PracticeItem("p43","The table is made ___ wood.","of",listOf("of","from","by","with"),"কাঠ দিয়ে তৈরি।","material = of।","source"),
    // COMPOUND
    PracticeItem("p44","She succeeded ___ difficulties.","in spite of",listOf("in spite of","despite of","because of","in case of"),"কষ্ট সত্ত্বেও।","in spite of।","compound"),
    PracticeItem("p45","She drank juice ___ tea.","instead of",listOf("instead of","in place","rather than","without"),"চায়ের পরিবর্তে।","instead of।","compound"),
    PracticeItem("p46","___ the report, it will rain.","According to",listOf("According to","Due to","In case of","By means of"),"রিপোর্ট অনুযায়ী।","according to।","compound"),
    PracticeItem("p47","She stood ___ the class.","in front of",listOf("in front of","in spite of","instead of","in case of"),"ক্লাসের সামনে।","in front of।","compound"),
    PracticeItem("p48","___ English, she knows French.","In addition to",listOf("In addition to","Instead of","According to","In front of"),"ইংরেজি ছাড়াও।","in addition to।","compound"),
    PracticeItem("p49","He spoke ___ the team.","on behalf of",listOf("on behalf of","instead of","in front of","according to"),"দলের পক্ষে।","on behalf of।","compound"),
    PracticeItem("p50","___ her tiredness, she kept working.","Despite",listOf("Despite","Although","Because of","In case of"),"ক্লান্তি সত্ত্বেও।","despite।","compound"),
)

val allStories = listOf(
    StoryItem("story1","A Day at the Park","""
Yesterday, I went [to] the park [near] my house. I arrived [at] 9 AM and stayed [until] noon.
I sat [on] a bench [beside] the fountain. Children were playing [around] the park.
Some were running [across] the grass. Others were climbing [up] the trees.
A little girl was hiding [behind] a big tree.
I had my lunch [at] 12 PM. I ate a sandwich made [of] vegetables.
I drank juice [from] a bottle I had brought [with] me.
[After] lunch, I walked [along] the river bank. The river flows [through] the city.
I could see fish swimming [below] the surface of the water.
I left the park [at] 1 PM and went home. I slept [for] two hours [during] the afternoon.
    """.trimIndent(),
        listOf("to","near","at","until","on","beside","around","across","up","behind","at","of","from","with","after","along","through","below","at","for","during"),
        listOf(StoryQuestion("When did the narrator arrive at the park?","at 9 AM",
            listOf("at 8 AM","at 9 AM","in the morning","at noon")),
            StoryQuestion("Where was the little girl hiding?","behind a big tree",
                listOf("under a tree","behind a big tree","beside the fountain","in the park")),
            StoryQuestion("How long did the narrator sleep?","for two hours",
                listOf("for one hour","for two hours","during an hour","until evening")))),

    StoryItem("story2","The Lost Key","""
Maria looked [for] her key everywhere. She searched [under] the pillow and [behind] the curtains.
She looked [inside] every drawer and [on] every shelf.
[After] ten minutes, she found it [in] her jacket pocket. The jacket was hanging [on] a hook [beside] the door.
She had left it there [before] going [to] bed.
[With] the key [in] her hand, she locked the door [from] inside and went [out of] the house [through] the back door.
She walked [along] the street [toward] the bus station.
The bus arrived [at] 8:30 AM. She got [on] the bus and sat [next to] the window.
She reached the office [within] fifteen minutes.
Her boss was standing [in front of] the reception desk [with] some files [in] his hand.
    """.trimIndent(),
        listOf("for","under","behind","inside","on","after","in","on","beside","before","to","with","in","from","out of","through","along","toward","at","on","next to","within","in front of","with","in"),
        listOf(StoryQuestion("Where did Maria find her key?","in her jacket pocket",
            listOf("under the pillow","behind the curtains","in her jacket pocket","on the shelf")),
            StoryQuestion("How did Maria get to the office?","by bus",
                listOf("by taxi","by bus","on foot","through the city")),
            StoryQuestion("Where was the boss standing?","in front of the reception desk",
                listOf("beside the door","behind the desk","in front of the reception desk","at the office")))),

    StoryItem("story3","The Hiking Adventure","""
Rafi and his friends decided to hike [up] the hill [outside] their town.
They started [from] the village [at] 6 AM. The trail went [through] a dense forest.
They walked [along] a small stream [for] two hours. [After] the forest, the path went [up] a steep slope.
They climbed [over] some rocks and walked [across] a narrow bridge [above] a waterfall.
[By] noon, they reached the top. The view [from] the summit was breathtaking.
They sat [on] the grass [near] a large stone. They ate sandwiches made [of] fresh vegetables.
[During] lunch, a gentle breeze blew [across] the hilltop.
[After] resting [for] thirty minutes, they walked back [down] the hill.
They arrived home [before] sunset, tired but happy.
    """.trimIndent(),
        listOf("up","outside","from","at","through","along","for","after","up","over","across","above","by","from","on","near","of","during","across","after","for","down","before"),
        listOf(StoryQuestion("When did they start the hike?","at 6 AM",
            listOf("at 5 AM","at 6 AM","in the morning","at 7 AM")),
            StoryQuestion("What was above the waterfall?","a narrow bridge",
                listOf("a large stone","a narrow bridge","a steep slope","a dense forest")),
            StoryQuestion("When did they arrive home?","before sunset",
                listOf("after sunset","before sunset","at noon","during the afternoon")))),

    StoryItem("story4","A Letter to a Friend","""
Dear Sadia,
I am writing this letter [from] my new home [in] Sylhet. I moved here [on] the 15th of last month.
I have been living here [for] three weeks now, and I love it [despite] the cold weather.
My new school is [near] our house — just two minutes [from] here [on] foot.
The teachers are very kind [to] the students. [In] the morning, I walk [to] school [along] the road [beside] the park.
[During] lunch break, we sit [on] the grass [in front of] the main building.
[After] school, I usually study [for] two hours [at] home.
[On] weekends, my family goes [to] a nearby lake. We sit [by] the water and enjoy the view.
I miss you a lot. Please write [to] me [at] my new address.
[With] love, Nadia
    """.trimIndent(),
        listOf("from","in","on","for","despite","near","from","on","to","in","to","along","beside","during","on","in front of","after","for","at","on","to","by","to","at","with"),
        listOf(StoryQuestion("Where is the narrator's new home?","in Sylhet",
            listOf("in Dhaka","in Sylhet","near the park","outside the town")),
            StoryQuestion("How far is the school from home?","two minutes on foot",
                listOf("five minutes away","two minutes on foot","beside the park","along the road")),
            StoryQuestion("Where does the family go on weekends?","to a nearby lake",
                listOf("to the park","to a nearby lake","beside the school","in front of the building")))),

    StoryItem("story5","The Science Fair","""
The annual science fair was held [at] the school [on] Saturday. Students came [from] different classes.
Some had been working [on] their projects [for] months. Others had started [just] a week [before] the event.
Rahim's project was [about] solar energy. He placed his model [on] a table [in the middle of] the hall.
[Next to] him was Sara, whose project was [about] water purification.
The judges walked [through] each row, examining every project [with] great interest.
[After] two hours, the results were announced. Rahim stood [in front of] the whole school.
He received first prize [from] the principal. He held the trophy [with] both hands and smiled.
Everyone clapped. [Among] all the winners, he was the youngest.
    """.trimIndent(),
        listOf("at","on","from","on","for","before","about","on","in the middle of","next to","about","through","with","after","in front of","from","with","among"),
        listOf(StoryQuestion("Where was the science fair held?","at the school",
            listOf("at the park","at the school","in the hall","on Saturday")),
            StoryQuestion("What was Rahim's project about?","solar energy",
                listOf("water purification","solar energy","recycling","computers")),
            StoryQuestion("Who gave Rahim the prize?","the principal",
                listOf("the teacher","the judges","the principal","his classmates"))))
)
