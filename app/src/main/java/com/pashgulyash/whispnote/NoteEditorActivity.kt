per.addNote(title, content)
            setResult(RESULT_OK)
            finish() // Явное закрытие активности
        }ashgulyash.whispnote.databinding.ActivityNoteEditorBinding
import com.pashgulyash.whispnote.db.DatabaseHelper

class NoteEditorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNoteEditorBinding
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteEditorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        dbHelper = DatabaseHelper(this)

        binding.btnSave.setOnClickListener {
            val title = binding.etTitle.text.toString().trim()
            val content = binding.etContent.text.toString().trim()
            
            if (title.isEmpty()) {
                binding.etTitle.error = "Введите заголовок"
                return@setOnClickListener
            }

            val id = dbHelper.addNote(title, content)
    Log.d("SAVE_DEBUG", "Сохранено с ID: $id")
    
            setResult(RESULT_OK)
            finish() // Явное закрытие активности
        }
    }
}
