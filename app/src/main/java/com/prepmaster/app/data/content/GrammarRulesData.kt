package com.prepmaster.app.data.content

import com.prepmaster.app.data.model.GrammarRule
import com.prepmaster.app.data.model.PrepExample

val allGrammarRules = listOf(
    GrammarRule("gr1","Rule 1: IN / ON / AT (Place)","অবস্থানের তিনটি মূল Preposition",
        """• IN — বড় জায়গা বা enclosed space: city, country, room, box
• ON — surface এর উপরে: table, wall, floor, road
• AT — নির্দিষ্ট একটি বিন্দু বা ঠিকানা: door, corner, stop""",
        "ON the road (রাস্তায়) কিন্তু IN the street (UK usage)",
        listOf(PrepExample("She lives IN Dhaka, ON the main road, AT house no. 5.",
            "সে ঢাকায়, প্রধান সড়কে, ৫ নম্বর বাড়িতে।","in/on/at"))),

    GrammarRule("gr2","Rule 2: IN / ON / AT (Time)","সময়ের তিনটি মূল Preposition",
        """• IN — year, month, season, part of day: IN 2024, IN March, IN summer, IN the morning
• ON — day, date, special day: ON Monday, ON June 5th, ON my birthday
• AT — clock time, specific moment: AT 9 AM, AT midnight, AT noon""",
        "AT night (রাতে) কিন্তু IN the night (রাতের বেলা)",
        listOf(PrepExample("Born IN 1995, ON a Monday, AT 6 AM.",
            "১৯৯৫ সালে, সোমবারে, ভোর ৬টায়।","in/on/at"))),

    GrammarRule("gr3","Rule 3: SINCE vs FOR","সময়কালের পার্থক্য",
        """• SINCE — নির্দিষ্ট point থেকে এখন পর্যন্ত। Present Perfect tense।
  Format: SINCE + specific time (2010, Monday, last week)
• FOR — কতক্ষণ ধরে — duration। যেকোনো tense।
  Format: FOR + period (3 hours, 2 years, a week)""",
        "SINCE আগে specific date/time, FOR আগে period",
        listOf(PrepExample("She has lived here FOR 5 years / SINCE 2019.",
            "৫ বছর ধরে / ২০১৯ থেকে থাকছে।","since/for"))),

    GrammarRule("gr4","Rule 4: TO / INTO / ONTO","গন্তব্য Preposition",
        """• TO — direction বা destination: go to school, walk to market
• INTO — বাইরে থেকে ভেতরে প্রবেশ: walk INTO the room, jump INTO the pool
• ONTO — নিচ থেকে surface-এ উঠে যাওয়া: jump ONTO the table, climb ONTO the roof""","",
        listOf(PrepExample("She walked TO the store, INTO the building, and ONTO the elevator.",
            "দোকানে গেল, বিল্ডিংয়ে ঢুকল, elevator-এ উঠল।","to/into/onto"))),

    GrammarRule("gr5","Rule 5: BY / WITH / THROUGH","উপায়ের Preposition",
        """• BY — transport mode / passive agent: travel BY bus; written BY Tagore
• WITH — instrument/tool / accompaniment: write WITH a pen; go WITH friends
• THROUGH — channel/medium: communicate THROUGH email; learn THROUGH practice""","",
        listOf(PrepExample("The message was sent BY her THROUGH email WITH great care.",
            "সে ইমেইলের মাধ্যমে সতর্কতার সাথে পাঠাল।","by/with/through"))),

    GrammarRule("gr6","Rule 6: BECAUSE OF / DUE TO","কারণ Preposition",
        """• BECAUSE OF — সাধারণ/কথ্য: because of + noun/pronoun
• DUE TO — formal writing: due to + noun
• OWING TO — সবচেয়ে formal: owing to + noun
সবগুলোর পরে noun বসে (verb নয়)।""",
        "এদের পরে never clause বসে (verb+subject নয়)",
        listOf(PrepExample("Delayed BECAUSE OF / DUE TO / OWING TO the storm.",
            "ঝড়ের কারণে বিলম্বিত।","because of/due to"))),

    GrammarRule("gr7","Rule 7: IN SPITE OF / DESPITE","বাধা সত্ত্বেও",
        """• IN SPITE OF = DESPITE — দুটির অর্থ একই: সত্ত্বেও
• এদের পরে noun বা gerund (verb+ing) বসে
• ALTHOUGH/THOUGH — এদের পরে clause (subject + verb) বসে""","",
        listOf(PrepExample("IN SPITE OF the rain / DESPITE the rain, she went.",
            "বৃষ্টি সত্ত্বেও গেল।","in spite of/despite"))),

    GrammarRule("gr8","Rule 8: OVER vs ABOVE","উপরে দুটির পার্থক্য",
        """• OVER — সরাসরি উপরে, কভার অর্থেও, movement possible
  Use: bridge OVER river, jump OVER fence, spread blanket OVER bed
• ABOVE — শুধু উচ্চতায় উপরে, কোনো কভার নেই
  Use: temperature ABOVE 40, mountain ABOVE sea level""","",
        listOf(PrepExample("The plane flew ABOVE the clouds / The bridge is OVER the river.",
            "মেঘের উপরে / নদীর উপরে সেতু।","over/above"))),

    GrammarRule("gr9","Rule 9: BETWEEN vs AMONG","মাঝে দুটির পার্থক্য",
        """• BETWEEN — শুধু দুটির মধ্যে: between A and B
• AMONG — তিন বা তার বেশির মধ্যে: among the students
Modern English: BETWEEN এখন 3+ এর জন্যেও ব্যবহার হয় (informal)""","",
        listOf(PrepExample("Divide BETWEEN two / AMONG many friends.",
            "দুজনের মধ্যে / অনেকের মধ্যে ভাগ।","between/among"))),

    GrammarRule("gr10","Rule 10: Compound Prepositions","যৌগিক Preposition-এর নিয়ম",
        """Compound Prepositions সবসময় noun/gerund এর আগে বসে:
• in front of / behind / on top of — অবস্থান
• in spite of / despite — বাধা সত্ত্বেও
• instead of — পরিবর্তে
• according to — অনুযায়ী
• in addition to — ছাড়াও
• on behalf of — পক্ষে
• by means of — মাধ্যমে
• in case of — ক্ষেত্রে""","",
        listOf(PrepExample("IN ADDITION TO English, she knows French.",
            "ইংরেজি ছাড়াও ফরাসি জানে।","compound")))
)
