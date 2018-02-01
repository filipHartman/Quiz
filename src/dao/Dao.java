package dao;

import model.QuestionModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Dao {
    private Connection connection;

    public void connectToDatabase() {
        try {
            connection = DbConnection.getConnection();
        } catch (ClassNotFoundException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public HashMap<Integer, String> importQuestionTypes() {
        HashMap<Integer, String> typeNamesCollection = new HashMap<Integer, String>();
        PreparedStatement ps;
        String query = "SELECT * FROM types";
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String typeName = rs.getString("type_name");
                Integer typeId = rs.getInt("id_type");
                typeNamesCollection.put(typeId, typeName);
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        return typeNamesCollection;
    }

    public void exportNewTypeToDb (String typeName) {
        PreparedStatement ps;
        String query = "INSERT INTO types(type_name) values (?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, typeName);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.out.println("Type insertion failed");
        }
    }

    public ArrayList<QuestionModel> importAllQuestionsFromDb() {
        ArrayList<QuestionModel> allQuestion = new ArrayList<>();
        PreparedStatement ps;
        String query = "SELECT * FROM questions";
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                QuestionModel question = createQuestionModel(rs);
                allQuestion.add(question);
            }

        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return allQuestion;
    }

    private QuestionModel createQuestionModel(ResultSet rs) throws SQLException {
        String questionType = getQuestionType(rs.getInt("id_type"));
        String questionContent = rs.getString("question_content");
        HashMap<String, String> answers = getAnswersOfQuestion(rs);
        String correctAnswer = rs.getString("correct_answer");
        QuestionModel question = new QuestionModel(questionType, questionContent, answers, correctAnswer);
        return question;
    }

    private HashMap<String,String> getAnswersOfQuestion(ResultSet rs) throws SQLException {
        HashMap<String, String> answers = new HashMap<>();
        answers.put("A", rs.getString("answer_a"));
        answers.put("B", rs.getString("answer_b"));
        answers.put("C", rs.getString("answer_c"));
        answers.put("D", rs.getString("answer_d"));
        return answers;
    }

    private String getQuestionType(int id_type) {
        String questionType = null;
        PreparedStatement ps;
        String query = "SELECT type_name FROM types WHERE id_type = ?";
        try{
            ps = connection.prepareStatement(query);
            ps.setInt(1, id_type);
            ResultSet rs = ps.executeQuery();
            questionType = rs.getString("type_name");
        }catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return questionType;
    }
}
