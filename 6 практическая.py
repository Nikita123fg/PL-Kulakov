import re
text=input("Введите текст:")
word=input("Введите слово:")
clean_text=re.sub(r'[^\w\s]', '',text.lower())
clean_word=re.sub(r'[^\w\s]', '',word.lower())
count=clean_text.split().count(clean_word)
print(f"Слово '{word}' встречается в тексте {count} раз.")
