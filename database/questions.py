import csv
import sqlite3

conn = sqlite3.connect('questions.sqlite')
c = conn.cursor()
print "Opened database successfully";
conn.execute('''CREATE TABLE questions
       (OPTION1           TEXT    NOT NULL,
        OPTION2            TEXT     NOT NULL);''')

with open('Questions.csv','rb') as fin:
    dr = csv.DictReader(fin)
    to_db = [(i['OPTION1'], i['OPTION2']) for i in dr]

c.executemany("INSERT INTO QUESTIONS (OPTION1, OPTION2) VALUES (?, ?);", to_db)


conn.commit()
conn.close()
