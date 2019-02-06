package com.company;

import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONException;
import org.json.JSONObject;

public class YairLoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String u = request.getParameter("k1");
        String p =request.getParameter("k2");

        UserBeam userBeam = new UserBeam();
        userBeam.setUserName(u);
        userBeam.setPassword(p);

        Register register = new Register();
        int i = register.registerUser(userBeam);

        if (i > 0){
            System.out.println("Register successful");
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("REGISTER","SUCCESS");
                PrintWriter pw =response.getWriter();
                pw.write(jsonObject.toString());
                pw.print(jsonObject.toString());

                System.out.println("REGISTER Successful"+ jsonObject.toString());

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
