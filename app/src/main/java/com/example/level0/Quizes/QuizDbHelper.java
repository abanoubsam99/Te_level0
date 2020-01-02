package com.example.level0.Quizes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "TeAgea0Test.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE1C = "CREATE TABLE " +
                QuizContact.QuestionsTable.TABLE_NAME1C + " ( " +
                QuizContact.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContact.QuestionsTable.COLUMN_QUESTION1C + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION11C + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION21C + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION31C + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_ANSWER_NR1C + " INTEGER" +
                ")";



        final String SQL_CREATE_QUESTIONS_TABLE1T = "CREATE TABLE " +
                QuizContact.QuestionsTable.TABLE_NAME1T + " ( " +
                QuizContact.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContact.QuestionsTable.COLUMN_QUESTION1T + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION11T + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION21T + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION31T + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_ANSWER_NR1T + " INTEGER" +
                ")";



        final String SQL_CREATE_QUESTIONS_TABLE2C = "CREATE TABLE " +
                QuizContact.QuestionsTable.TABLE_NAME2C + " ( " +
                QuizContact.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContact.QuestionsTable.COLUMN_QUESTION2C + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION12C + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION22C + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION32C + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_ANSWER_NR2C + " INTEGER" +
                ")";


        final String SQL_CREATE_QUESTIONS_TABLE2T = "CREATE TABLE " +
                QuizContact.QuestionsTable.TABLE_NAME2T + " ( " +
                QuizContact.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContact.QuestionsTable.COLUMN_QUESTION2T + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION12T + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION22T + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION32T + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_ANSWER_NR2T + " INTEGER" +
                ")";




        db.execSQL(SQL_CREATE_QUESTIONS_TABLE1C);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE1T);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE2C);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE2T);

        fillQuestionsTable1C();
        fillQuestionsTable1T();
        fillQuestionsTable2C();
        fillQuestionsTable2T();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +  QuizContact.QuestionsTable.TABLE_NAME1C);
        db.execSQL("DROP TABLE IF EXISTS " +  QuizContact.QuestionsTable.TABLE_NAME1T);
        db.execSQL("DROP TABLE IF EXISTS " +  QuizContact.QuestionsTable.TABLE_NAME2C);
        db.execSQL("DROP TABLE IF EXISTS " +  QuizContact.QuestionsTable.TABLE_NAME2T);

        onCreate(db);
    }

    //1C


    private void fillQuestionsTable1C() {
        Questions q1 = new Questions("اختر شكل  حرف الفا ", "A", "J", "D", 1);
        addQuestion1C(q1);
        Questions q2 = new Questions("اختر شكل  حرف فيتا ", "T", "B", "S", 2);
        addQuestion1C(q2);
        Questions q3 = new Questions("اختر شكل  حرف غما", "@", "R", "J", 3);
        addQuestion1C(q3);
        Questions q4 = new Questions("اختر شكل  حرف دلتا", "L", "A", "D", 3);
        addQuestion1C(q4);
        Questions q5 = new Questions("اختر شكل  حرف أي", "Y", "E", "K", 2);
        addQuestion1C(q5);
        Questions q6 = new Questions("اختر شكل  حرف سو", "^", "O", "X", 1);
        addQuestion1C(q6);
        Questions q7 = new Questions("اختر شكل  حرف زيتا", "Z", "I", "#", 1);
        addQuestion1C(q7);
        Questions q8 = new Questions("اختر شكل  حرف إيتا  ", "N", "#", "|Z", 2);
        addQuestion1C(q8);
        Questions q9 = new Questions("اختر شكل  حرف لولا - لفلا", "L", "A", "D", 1);
        addQuestion1C(q9);
        Questions q10 = new Questions("اختر شكل  حرف مي", "m", "v", "n", 1);
        addQuestion1C(q10);
        Questions q11 = new Questions("اختر شكل  حرف ني ", "v", "n", "m", 2);
        addQuestion1C(q11);
        Questions q12 = new Questions("اختر شكل  حرف اكسي", "Z", "@", "&", 3);
        addQuestion1C(q12);
        Questions q13 = new Questions("اختر شكل  حرف اوميكرون", "P", ")", "O", 3);
        addQuestion1C(q13);
        Questions q14 = new Questions("اختر نطق الرقم التالي : 1 ", "ميت", "أواي", "بسيت", 2);
        addQuestion1C(q14);
        Questions q15 = new Questions("اختر نطق الرقم التالي : 2", "اسناف", "أشميت", "شاشف", 1);
        addQuestion1C(q15);
        Questions q16 = new Questions("اختر نطق الرقم التالي : 3", "شمت", "افتو", "بسيت", 1);
        addQuestion1C(q16);
        Questions q17 = new Questions("اختر نطق الرقم التالي : 4 ", "اتيو", "افتو", "سوؤو", 2);
        addQuestion1C(q17);
        Questions q18 = new Questions("اختر نطق الرقم التالي : 5", "شاشف", "اسناف", "اتيو", 3);
        addQuestion1C(q18);
        Questions q19 = new Questions("اختر نطق الرقم التالي : 6 ", "شمت", "سوؤو", "افتو", 2);
        addQuestion1C(q19);
        Questions q20 = new Questions("اختر نطق الرقم التالي : 8", "اشميت", "افتو", "سوؤو", 1);
        addQuestion1C(q20);
        Questions q21 = new Questions("اختر نطق الرقم التالي : 9 ", "اشميت", "ميت", "بسيت", 3);
        addQuestion1C(q21);
        Questions q22 = new Questions("اختر نطق الرقم التالي : 10", "ميت", "شاشف", "افتو ", 1);
        addQuestion1C(q22);
        Questions q23= new Questions("اختر شكل  حرف ثيتا", "E", "M", ")", 3);
        addQuestion1C(q23);
        Questions q24= new Questions("اختر شكل  حرف يوطا", "Q", "V", "I", 3);
        addQuestion1C(q24);
        Questions q25 = new Questions("اختر شكل  حرف كبا ", "J", "K", "X", 2);
        addQuestion1C(q25);
        Questions q26 = new Questions("اختر نطق الرقم التالي : 7", "شاشف", "اسناف", "اتيو", 1);
        addQuestion1C(q26);

    }

    private void addQuestion1C(Questions question) {
        ContentValues cv = new ContentValues();
        cv.put( QuizContact.QuestionsTable.COLUMN_QUESTION1C, question.getQuestion1C());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION11C, question.getOption11C());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION21C, question.getOption21C());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION31C, question.getOption31C());
        cv.put( QuizContact.QuestionsTable.COLUMN_ANSWER_NR1C, question.getAnswerNr1C());
        db.insert( QuizContact.QuestionsTable.TABLE_NAME1C, null, cv);
    }

    public ArrayList<Questions> getAllQuestions1C() {
        ArrayList<Questions> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContact.QuestionsTable.TABLE_NAME1C, null);

        if (c.moveToFirst()) {
            do {
                Questions question = new Questions();
                question.setQuestion1C(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_QUESTION1C)));
                question.setOption11C(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION11C)));
                question.setOption21C(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION21C)));
                question.setOption31C(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION31C)));
                question.setAnswerNr1C(c.getInt(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_ANSWER_NR1C)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }



    // 1T

    private void fillQuestionsTable1T() {
        Questions1T q1 = new Questions1T("انا اذهب الي الكنيسة وانا ......", "فرحان ", "زعلان ", "نايم", 1);
        addQuestion1T(q1);
        Questions1T q2 = new Questions1T("وانا رايح الكنيسة بقول مزمور......", "طوبي للرجل الذي لم يسلك في مشورة المنافقين", "فرحت بالقائلين لي الي بيت الرب نذهب ", "اعظمك يا رب ", 2);
        addQuestion1T(q2);
        Questions1T q3 = new Questions1T("اول لما ادخل الكنيسة اسلم علي مين الاول ؟", "صاحبي ", "استاذي", "ربنا ", 3);
        addQuestion1T(q3);
        Questions1T q4 = new Questions1T("اول حاجه اعملها لما ادخل الكنيسة هي ايه؟", "ارشم الصليب", "اسلم علي صاحبي", "العب في الموبايل", 1);
        addQuestion1T(q4);
        Questions1T q5 = new Questions1T("الكنيسة شبة ايه.؟", "الشارع ", "السماء", "البيت", 2);
        addQuestion1T(q5);
        Questions1T q6 = new Questions1T("الكنيسة هي اية؟", "مكان بلعب فيه", "مكان اكل فيه", "بيت اللة ", 3);
        addQuestion1T(q6);
        Questions1T q7 = new Questions1T("انا بولع شمعة قدام  ......", "الايقونة", "ابونا ", "الاكل", 1);
        addQuestion1T(q7);
        Questions1T q8 = new Questions1T("بسمع كلام ووصايا ربنا في الانجيل من علي ......", "السحاب", "المنجلية ", "الهيكل ", 2);
        addQuestion1T(q8);
        Questions1T q9 = new Questions1T("اية اهم حاجة في الهيكل ؟", "الشمع", "كرسي ابونا", "المذبح", 3);
        addQuestion1T(q9);
        Questions1T q10 = new Questions1T("بنشوف في القداس الصينية زي اية؟", "مزود المسيح ", "سرير ", "صليب", 1);
        addQuestion1T(q10);
        Questions1T q11 = new Questions1T("الشورية من  رموز .....", "المسيح", "العذراء مريم", "الشهيد ابانوب", 2);
        addQuestion1T(q11);
        Questions1T q12 = new Questions1T("وانا بصلي لازم اعمل ايه ؟", "اتكلم مع اي حد ", "العب مع صحابي ", "اقف ساكت ومكلمش حد خالص غير بابا يسوع", 3);
        addQuestion1T(q12);
        Questions1T q13 = new Questions1T("لازم احافظ علي الكنيسة وما ارميش حاجة علي الارض ؟", "صح", "غلط", "مش عارف", 1);
        addQuestion1T(q13);
        Questions1T q14 = new Questions1T("لازم احترم اللي اكبر مني واسمع كلامة ؟", "غلط ", "صح", "مش عارف", 2);
        addQuestion1T(q14);

    }

    private void addQuestion1T(Questions1T question) {
        ContentValues cv = new ContentValues();
        cv.put( QuizContact.QuestionsTable.COLUMN_QUESTION1T, question.getQuestion1T());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION11T, question.getOption11T());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION21T, question.getOption21T());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION31T, question.getOption31T());
        cv.put( QuizContact.QuestionsTable.COLUMN_ANSWER_NR1T, question.getAnswerNr1T());
        db.insert( QuizContact.QuestionsTable.TABLE_NAME1T, null, cv);
    }

    public ArrayList<Questions1T> getAllQuestions1T() {
        ArrayList<Questions1T> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContact.QuestionsTable.TABLE_NAME1T, null);

        if (c.moveToFirst()) {
            do {
                Questions1T question = new Questions1T();
                question.setQuestion1T(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_QUESTION1T)));
                question.setOption11T(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION11T)));
                question.setOption21T(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION21T)));
                question.setOption31T(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION31T)));
                question.setAnswerNr1T(c.getInt(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_ANSWER_NR1T)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }



    // 2C

    private void fillQuestionsTable2C() {
        Questions2C q1 = new Questions2C("اختر شكل حرف بي", "P", "R", "T", 1);
        addQuestion2C(q1);
        Questions2C q2 = new Questions2C("اختر شكل حرف رو", "$", "R", "B", 2);
        addQuestion2C(q2);
        Questions2C q3 = new Questions2C("اختر شكل حرف سيما", "H", "J", "C", 3);
        addQuestion2C(q3);
        Questions2C q4 = new Questions2C("اختر شكل  حرف تاف", "t", "%", "W", 1);
        addQuestion2C(q4);
        Questions2C q5 = new Questions2C("اختر شكل  حرف ابسلون", "C", "V", "X", 2);
        addQuestion2C(q5);
        Questions2C q6 = new Questions2C("اختر شكل  حرف في ", "D", "G", "F", 3);
        addQuestion2C(q6);
        Questions2C q7 = new Questions2C("اختر شكل  حرف كي", "X", "C", "V", 1);
        addQuestion2C(q7);
        Questions2C q8 = new Questions2C("اختر شكل  حرف إبس ", "R", "Y", "T", 2);
        addQuestion2C(q8);
        Questions2C q9 = new Questions2C("اختر شكل  حرف أوميجا", "W", "E", "Q", 1);
        addQuestion2C(q9);
        Questions2C q10 = new Questions2C("اختر شكل  حرف فاي", "R", "$", "H", 2);
        addQuestion2C(q10);
        Questions2C q11 = new Questions2C("اختر شكل  حرف خاي", "E", "W", "Q", 3);
        addQuestion2C(q11);
        Questions2C q12 = new Questions2C("اختر شكل  حرف هوري", "H", "J", "K", 1);
        addQuestion2C(q12);
        Questions2C q13 = new Questions2C("اختر شكل  حرف جنجا", "H", "J", "G", 2);
        addQuestion2C(q13);
        Questions2C q14 = new Questions2C("اختر شكل  حرف تشيما ", "A", "D", "S", 3);
        addQuestion2C(q14);
        Questions2C q15 = new Questions2C("اختر شكل  حرف تي", "%", "$", "^", 1);
        addQuestion2C(q15);
        Questions2C q16 = new Questions2C("اختر  معني الكلمة بالعربي:  بايوت Paiwt   ", "ماما", "بابا", "جدو", 2);
        addQuestion2C(q16);
        Questions2C q17 = new Questions2C("اختر  معني الكلمة بالعربي:باسون Pacon ", "اخي", "اختي", "ماما", 1);
        addQuestion2C(q17);
        Questions2C q18 = new Questions2C("اختر  معني الكلمة بالعربي: تاماف Tamav", "بابا", "ماما", "اختي", 2);
        addQuestion2C(q18);
        Questions2C q19 = new Questions2C("اختر  معني الكلمة بالعربي: با إي Pa3i  ", "كنيستي", "اخي", "بيتي", 3);
        addQuestion2C(q19);
        Questions2C q20= new Questions2C("اختر  معني الكلمة بالعربي: تي كليسيا Tekkl3cia", "كنيسة ", "مدرسة", "بيتي", 1);
        addQuestion2C(q20);
        Questions2C q21 = new Questions2C("اختر  معني الكلمة بالعربي: إرفي Erfei", "مدرسة ", "هيكل ", "كنيسة ", 2);
        addQuestion2C(q21);
        Questions2C q22 = new Questions2C("اختر  معني الكلمة بالعربي: إيسوس بيخرستوس  I3covc Pi`xrictoc ", "الشهيدة دميانة", "والدة الالة", "يسوع المسيح", 3);
        addQuestion2C(q22);

    }

    private void addQuestion2C(Questions2C question) {
        ContentValues cv = new ContentValues();
        cv.put( QuizContact.QuestionsTable.COLUMN_QUESTION2C, question.getQuestion2C());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION12C, question.getOption12C());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION22C, question.getOption22C());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION32C, question.getOption32C());
        cv.put( QuizContact.QuestionsTable.COLUMN_ANSWER_NR2C, question.getAnswerNr2C());
        db.insert( QuizContact.QuestionsTable.TABLE_NAME2C, null, cv);
    }

    public ArrayList<Questions2C> getAllQuestions2C() {
        ArrayList<Questions2C> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContact.QuestionsTable.TABLE_NAME2C, null);

        if (c.moveToFirst()) {
            do {
                Questions2C question = new Questions2C();
                question.setQuestion2C(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_QUESTION2C)));
                question.setOption12C(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION12C)));
                question.setOption22C(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION22C)));
                question.setOption32C(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION32C)));
                question.setAnswerNr2C(c.getInt(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_ANSWER_NR2C)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }



    // 2T

    private void fillQuestionsTable2T() {
        Questions2T q1 = new Questions2T("كم عدد اسرار الكنيسة؟", "7", "5 ", "4 ", 1);
        addQuestion2T(q1);
        Questions2T q2 = new Questions2T("لما خرجت من المعمودية الكنيسة بقت هي.....", "اختي", "امي", "اخويا", 2);
        addQuestion2T(q2);
        Questions2T q3 = new Questions2T("ابونا بيغطسنا في سر المعمودية كام مرة ؟", "20", "5 ", "3 ", 3);
        addQuestion2T(q3);
        Questions2T q4 = new Questions2T("ابونا بيرشمنا في سر الميرون بزيت ......", "الميرون", "عباد شمس", "زيتون", 1);
        addQuestion2T(q4);
        Questions2T q5 = new Questions2T("ابونا بيرشمنا 36 مرة في سر اية؟", "التناول", "المعمودية ", "مسحة المرضي", 2);
        addQuestion2T(q5);
        Questions2T q6 = new Questions2T("بروح اعترف عن خطيتي لمين؟", "لصاحبي", "للخادم بتاعي", "لابونا ", 3);
        addQuestion2T(q6);
        Questions2T q7 = new Questions2T("في سر التناول  باكل ايه؟", "جسد ربنا يسوع المسيح", "سندوتش", "شيبسي", 1);
        addQuestion2T(q7);
        Questions2T q8 = new Questions2T("في سر التناول بشرب اية؟ ", "عصير ", "دم المسيح", "بيبسي", 2);
        addQuestion2T(q8);
        Questions2T q9 = new Questions2T("كل اسرار الكنيسة بيقدمها ليا مين ؟ ", "اخويا", "التاسوني", "ابونا ", 3);
        addQuestion2T(q9);
        Questions2T q10= new Questions2T("في سر مسحة المرضي ابونا بيرشمني بزيت اية؟", "بزيت مسحة المرضي", "بزيت سمسم", "بزيت عباد الشمس", 1);
        addQuestion2T(q10);
        Questions2T q11 = new Questions2T("في سر مسحة المرضي ابونا بيرشمنا بالزيت عشان اية؟", "عشان اتعب اكتر", "عشان اخف من الخطية ومن المرض", "عشان انا عطشان", 2);
        addQuestion2T(q11);
        Questions2T q12 = new Questions2T("في  سر الزيجة حصل اية؟ ", "لعبنا كورة", "ابونا عمدني", "بابا وماما اتجوزوا وبقوا جسد واحد", 3);
        addQuestion2T(q12);
        Questions2T q13 = new Questions2T("المسيح هو ........الكنيسة ", "رأس", "بطن", "عين", 1);
        addQuestion2T(q13);


    }

    private void addQuestion2T(Questions2T question) {
        ContentValues cv = new ContentValues();
        cv.put( QuizContact.QuestionsTable.COLUMN_QUESTION2T, question.getQuestion2T());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION12T, question.getOption12T());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION22T, question.getOption22T());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION32T, question.getOption32TC());
        cv.put( QuizContact.QuestionsTable.COLUMN_ANSWER_NR2T, question.getAnswerNr2T());
        db.insert( QuizContact.QuestionsTable.TABLE_NAME2T, null, cv);
    }

    public ArrayList<Questions2T> getAllQuestions2T() {
        ArrayList<Questions2T> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContact.QuestionsTable.TABLE_NAME2T, null);

        if (c.moveToFirst()) {
            do {
                Questions2T question = new Questions2T();
                question.setQuestion2T(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_QUESTION2T)));
                question.setOption12T(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION12T)));
                question.setOption22T(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION22T)));
                question.setOption32TC(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION32T)));
                question.setAnswerNr2T(c.getInt(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_ANSWER_NR2T)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }



}


