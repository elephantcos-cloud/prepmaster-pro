package com.prepmaster.app.data.content

import com.prepmaster.app.data.model.*

val allComparisonGroups = listOf(

    ComparisonGroup("cmp1","IN / ON / AT — স্থান","অবস্থান: তিনটির পার্থক্য",0xFF00C6FF,
        listOf(
            ComparisonItem("IN","ভেতরে",
                "বন্ধ বা enclosed স্থানে। যেমন: ঘর, শহর, দেশ।",
                listOf(PrepExample("She is IN the room.","সে ঘরের ভেতরে।","IN"),
                    PrepExample("He lives IN Dhaka.","সে ঢাকায় থাকে।","IN"),
                    PrepExample("The keys are IN the box.","চাবি বাক্সে।","IN")),"img_in"),
            ComparisonItem("ON","উপরে (স্পর্শে)",
                "Surface-এ স্পর্শ করে উপরে। মেঝে, টেবিল, দেয়াল।",
                listOf(PrepExample("The book is ON the table.","বই টেবিলে।","ON"),
                    PrepExample("There is a picture ON the wall.","দেয়ালে ছবি।","ON"),
                    PrepExample("She sat ON the floor.","মেঝেতে বসল।","ON")),"img_on"),
            ComparisonItem("AT","নির্দিষ্ট বিন্দু",
                "কোনো নির্দিষ্ট পয়েন্ট বা ঠিকানা।",
                listOf(PrepExample("She is AT the bus stop.","বাস স্টপে।","AT"),
                    PrepExample("He is AT the door.","দরজায়।","AT"),
                    PrepExample("We met AT the corner.","কোণায় দেখা।","AT")),"img_at")
        )),

    ComparisonGroup("cmp2","IN / ON / AT — সময়","সময়: তিনটির পার্থক্য",0xFFFF6B6B,
        listOf(
            ComparisonItem("IN","দীর্ঘ সময়কাল",
                "মাস, বছর, দশক, মৌসুম, সকাল/বিকেল।",
                listOf(PrepExample("Born IN 2000.","২০০০ সালে জন্ম।","IN"),
                    PrepExample("IN the morning.","সকালে।","IN"),
                    PrepExample("IN March.","মার্চ মাসে।","IN")),"img_in_time"),
            ComparisonItem("ON","নির্দিষ্ট দিন/তারিখ",
                "দিন, তারিখ, বিশেষ দিন।",
                listOf(PrepExample("ON Monday.","সোমবারে।","ON"),
                    PrepExample("ON June 5th.","৫ জুনে।","ON"),
                    PrepExample("ON my birthday.","জন্মদিনে।","ON")),"img_on_time"),
            ComparisonItem("AT","নির্দিষ্ট সময়",
                "ঘড়ির সময়, নির্দিষ্ট মুহূর্ত।",
                listOf(PrepExample("AT 9 AM.","৯টায়।","AT"),
                    PrepExample("AT midnight.","মধ্যরাতে।","AT"),
                    PrepExample("AT noon.","দুপুরে।","AT")),"img_at_time")
        )),

    ComparisonGroup("cmp3","ABOVE / OVER / ON","উপরে: তিনটির পার্থক্য",0xFF00E676,
        listOf(
            ComparisonItem("ON","স্পর্শ করে উপরে",
                "Surface contact থাকে।",
                listOf(PrepExample("The pen is ON the desk.","কলম ডেস্কে।","ON"),
                    PrepExample("Put it ON the shelf.","তাকে রাখো।","ON")),"img_on"),
            ComparisonItem("OVER","স্পর্শ ছাড়া উপরে / ঢেকে",
                "সরাসরি উপরে, কভার বা movement থাকতে পারে।",
                listOf(PrepExample("The bridge is OVER the river.","নদীর উপরে সেতু।","OVER"),
                    PrepExample("She jumped OVER the fence.","বেড়া টপকাল।","OVER"),
                    PrepExample("Spread the blanket OVER the bed.","বিছানায় কম্বল।","OVER")),"img_over"),
            ComparisonItem("ABOVE","স্পর্শ ছাড়া উপরে (শুধু স্থান)",
                "কোনো স্পর্শ নেই, শুধু উচ্চতায় উপরে।",
                listOf(PrepExample("The temperature is ABOVE 40.","৪০ ডিগ্রির উপরে।","ABOVE"),
                    PrepExample("The plane flew ABOVE the clouds.","মেঘের উপর দিয়ে।","ABOVE")),"img_above")
        )),

    ComparisonGroup("cmp4","UNDER / BELOW / BENEATH","নিচে: তিনটির পার্থক্য",0xFFFFD700,
        listOf(
            ComparisonItem("UNDER","সরাসরি নিচে / ঢাকা",
                "সরাসরি নিচে, covered অর্থেও।",
                listOf(PrepExample("The cat is UNDER the table.","বিড়াল টেবিলের নিচে।","UNDER"),
                    PrepExample("UNDER the bridge.","সেতুর নিচে।","UNDER"),
                    PrepExample("UNDER pressure.","চাপে।","UNDER")),"img_under"),
            ComparisonItem("BELOW","স্পর্শ ছাড়া নিচে",
                "স্পর্শ করে না, শুধু নিচে।",
                listOf(PrepExample("10 degrees BELOW zero.","শূন্যের নিচে।","BELOW"),
                    PrepExample("Fish swim BELOW the surface.","পৃষ্ঠের নিচে।","BELOW")),"img_below"),
            ComparisonItem("BENEATH","সরাসরি নিচে (literary)",
                "Literary/formal ব্যবহারে।",
                listOf(PrepExample("BENEATH the ground.","মাটির নিচে।","BENEATH"),
                    PrepExample("She felt it was BENEATH her dignity.","তার মর্যাদার নিচে।","BENEATH")),"img_under")
        )),

    ComparisonGroup("cmp5","TO / INTO / ONTO","গন্তব্য Preposition",0xFFB06AFF,
        listOf(
            ComparisonItem("TO","গন্তব্য (direction)",
                "কোথায় যাচ্ছে তার দিক বোঝায়।",
                listOf(PrepExample("She went TO school.","স্কুলে গেল।","TO"),
                    PrepExample("He walked TO the market.","বাজারে গেল।","TO")),"img_to"),
            ComparisonItem("INTO","ভেতরে প্রবেশ",
                "বাইরে থেকে ভেতরে যাওয়া।",
                listOf(PrepExample("She walked INTO the room.","ঘরে ঢুকল।","INTO"),
                    PrepExample("He jumped INTO the pool.","পুলে ঝাঁপ দিল।","INTO")),"img_into"),
            ComparisonItem("ONTO","উপরে উঠে যাওয়া",
                "নিচ থেকে surface-এ উঠে যাওয়া।",
                listOf(PrepExample("The cat jumped ONTO the table.","টেবিলে উঠল।","ONTO"),
                    PrepExample("She climbed ONTO the roof.","ছাদে উঠল।","ONTO")),"img_onto")
        )),

    ComparisonGroup("cmp6","SINCE / FOR / DURING","সময়কাল Preposition",0xFFFF9800,
        listOf(
            ComparisonItem("SINCE","নির্দিষ্ট সময় থেকে এখন",
                "Past এর নির্দিষ্ট point থেকে এখন পর্যন্ত। Perfect tense।",
                listOf(PrepExample("I have lived here SINCE 2010.","২০১০ থেকে এখানে।","SINCE"),
                    PrepExample("She has been ill SINCE Monday.","সোমবার থেকে অসুস্থ।","SINCE")),"img_since"),
            ComparisonItem("FOR","সময়ের পরিমাণ",
                "কতক্ষণ — duration বোঝায়।",
                listOf(PrepExample("I studied FOR two hours.","দুই ঘণ্টা পড়লাম।","FOR"),
                    PrepExample("She waited FOR a week.","এক সপ্তাহ অপেক্ষা।","FOR")),"img_for_time"),
            ComparisonItem("DURING","একটি period এর মধ্যে",
                "কোনো event/period চলাকালীন।",
                listOf(PrepExample("DURING the exam.","পরীক্ষার সময়।","DURING"),
                    PrepExample("DURING the war.","যুদ্ধের সময়।","DURING")),"img_during")
        )),

    ComparisonGroup("cmp7","BY / WITH / THROUGH","উপায়/মাধ্যম",0xFF7C5CFC,
        listOf(
            ComparisonItem("BY","পরিবহন / Passive কর্তা",
                "Travel এ পরিবহন, Passive voice এ কর্তা।",
                listOf(PrepExample("Traveled BY train.","ট্রেনে।","BY"),
                    PrepExample("Written BY Tagore.","রবীন্দ্রনাথ কর্তৃক।","BY")),"img_by_manner"),
            ComparisonItem("WITH","হাতিয়ার / সাথে",
                "Tool/instrument বা accompaniment।",
                listOf(PrepExample("Write WITH a pen.","কলম দিয়ে।","WITH"),
                    PrepExample("Came WITH friends.","বন্ধুদের সাথে।","WITH")),"img_with"),
            ComparisonItem("THROUGH","মাধ্যম / পথে",
                "Channel বা medium দিয়ে।",
                listOf(PrepExample("Communicated THROUGH email.","ইমেইলের মাধ্যমে।","THROUGH"),
                    PrepExample("Learned THROUGH practice.","অনুশীলনের মাধ্যমে।","THROUGH")),"img_through")
        )),

    ComparisonGroup("cmp8","BECAUSE OF / DUE TO / OWING TO","কারণ Preposition",0xFFE91E63,
        listOf(
            ComparisonItem("BECAUSE OF","কারণে (সাধারণ)",
                "সাধারণ কথ্য ভাষায় কারণ।",
                listOf(PrepExample("Canceled BECAUSE OF rain.","বৃষ্টির কারণে।","BECAUSE OF"),
                    PrepExample("Late BECAUSE OF traffic.","যানজটের কারণে।","BECAUSE OF")),"img_because_of"),
            ComparisonItem("DUE TO","কারণে (formal)",
                "Formal writing এ কারণ।",
                listOf(PrepExample("Delayed DUE TO fog.","কুয়াশার কারণে।","DUE TO"),
                    PrepExample("Failed DUE TO negligence.","অবহেলার কারণে।","DUE TO")),"img_due_to"),
            ComparisonItem("OWING TO","কারণে (formal/written)",
                "সবচেয়ে formal — written English।",
                listOf(PrepExample("OWING TO the storm, flights were cancelled.","ঝড়ের কারণে ফ্লাইট বাতিল।","OWING TO"),
                    PrepExample("OWING TO his efforts, they won.","তার প্রচেষ্টার কারণে।","OWING TO")),"img_owing_to")
        )),

    ComparisonGroup("cmp9","BETWEEN / AMONG","মাঝে Preposition",0xFF00BCD4,
        listOf(
            ComparisonItem("BETWEEN","দুটির মাঝে",
                "শুধু দুটি বস্তু বা ব্যক্তির মাঝে।",
                listOf(PrepExample("The park is BETWEEN the school and hospital.","স্কুল ও হাসপাতালের মাঝে।","BETWEEN"),
                    PrepExample("A secret BETWEEN us.","আমাদের মধ্যে রহস্য।","BETWEEN")),"img_between"),
            ComparisonItem("AMONG","অনেকের মধ্যে",
                "তিন বা তার বেশির মধ্যে।",
                listOf(PrepExample("She is popular AMONG her friends.","বন্ধুদের মধ্যে জনপ্রিয়।","AMONG"),
                    PrepExample("AMONG the students.","ছাত্রছাত্রীদের মধ্যে।","AMONG")),"img_among")
        )),

    ComparisonGroup("cmp10","IN SPITE OF / DESPITE / ALTHOUGH","বাধা সত্ত্বেও",0xFF4CAF50,
        listOf(
            ComparisonItem("IN SPITE OF","সত্ত্বেও (+ noun)",
                "Noun বা gerund এর আগে।",
                listOf(PrepExample("IN SPITE OF the rain, she went.","বৃষ্টি সত্ত্বেও গেল।","IN SPITE OF"),
                    PrepExample("IN SPITE OF being tired.","ক্লান্ত সত্ত্বেও।","IN SPITE OF")),"img_in_spite_of"),
            ComparisonItem("DESPITE","সত্ত্বেও (+ noun, concise)",
                "= in spite of, আরো সংক্ষিপ্ত।",
                listOf(PrepExample("DESPITE the challenges.","চ্যালেঞ্জ সত্ত্বেও।","DESPITE"),
                    PrepExample("DESPITE her illness.","তার অসুস্থতা সত্ত্বেও।","DESPITE")),"img_despite"),
            ComparisonItem("ALTHOUGH","যদিও (+ clause)",
                "Conjunction — এর পরে subject+verb।",
                listOf(PrepExample("ALTHOUGH it was raining, she went.","যদিও বৃষ্টি ছিল।","ALTHOUGH"),
                    PrepExample("ALTHOUGH tired, he kept working.","যদিও ক্লান্ত ছিল।","ALTHOUGH")),"img_in_spite_of")
        ))
)
