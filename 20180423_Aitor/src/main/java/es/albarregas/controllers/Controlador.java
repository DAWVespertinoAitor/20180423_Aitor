/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Jugada;
import es.albarregas.beans.NumeroJugada;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author aitor
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    List<Integer> noSeRepite = new ArrayList<Integer>();
    List<NumeroJugada> listJugadas = new ArrayList<NumeroJugada>();
    int numeroJugadas = 0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "";

        int cantidadDigitos = 0;
        int ningunoSeRepite = 1;
        boolean sigueJugando = true;

        Jugada jugada = new Jugada();
        NumeroJugada jugadas = new NumeroJugada();

        if (request.getParameter("configurar") != null) {

            noSeRepite.clear();
            Random aleatorio = new Random();
            int longitudNumero = 0;
            boolean ningunoCoincide = false;
            cantidadDigitos = Integer.parseInt(request.getParameter("digitos"));
            url = "/JSP/juego.jsp";

            //Este "for" rellena el array con los numeros generados con la clase Random
            for (int i = 0; i < cantidadDigitos; i++) {
                int numeroAleatorio = -1;
                boolean generado = false;
                while (!generado) {
                    int posible = aleatorio.nextInt(10);
                    if (!noSeRepite.contains(posible)) {
                        noSeRepite.add(posible);
                        numeroAleatorio = posible;
                        generado = true;
                    }
                }
            }

            for (int i = 0; i < noSeRepite.size(); i++) {
                System.out.println("Numero " + noSeRepite.get(i));
            }
//            request.setAttribute("numeroAleatorio", noSeRepite);
            request.setAttribute("cantidadDigitos", cantidadDigitos);

        } else if (request.getParameter("enviar") != null) {

            int heridos = 0;
            int muertos = 0;

            cantidadDigitos = Integer.parseInt(request.getParameter("cantidadDigitos"));
            List<Integer> numerosIntroducidos = new ArrayList<Integer>();

            for (int i = 0; i < noSeRepite.size(); i++) {
                System.out.println(noSeRepite.get(i));
            }

            //Rellenamos un list con los numeros introducidos
            for (int i = 1; i <= cantidadDigitos; i++) {
                String numero = request.getParameter("numero" + i);
                numerosIntroducidos.add(Integer.parseInt(numero));
            }
            //Rellenamos el bean con los atributos necesarios
            jugada.setJugada(numeroJugadas);
            jugada.setNumero(numerosIntroducidos);

            //Con este for comprobamos numero generado por numero introducido para descubrir a los muertos 
            for (int i = 0; i < noSeRepite.size(); i++) {
                if (noSeRepite.contains(numerosIntroducidos.get(i)) && noSeRepite.get(i).equals(jugada.getNumero().get(i))) {
                    muertos = muertos + 1;
                }
            }
            //Con este for comprobamos numero generado por numero introducido para descubrir a los heridos 
            for (int i = 0; i < noSeRepite.size(); i++) {
                if (noSeRepite.contains(jugada.getNumero().get(i))) {
                    heridos = heridos + 1;
                }
            }

            heridos = heridos - muertos;
            
            if (numeroJugadas >= 1) {
                numeroJugadas = numeroJugadas + 1;
                jugada.setJugada(numeroJugadas);
                jugadas.setNumero(jugada.getJugada());
                jugadas.setHeridos(heridos);
                jugadas.setMuertos(muertos);
                listJugadas.add(jugadas);

                System.out.println("Holaaaaaaaa " + listJugadas.size());
                request.setAttribute("cantidadDigitos", cantidadDigitos);
                url = "/JSP/juego.jsp";
                request.setAttribute("numeroJugadas", listJugadas);
            }
            
            if (numeroJugadas == 0) {
                numeroJugadas = numeroJugadas + 1;
                jugada.setJugada(numeroJugadas);
                jugadas.setNumero(jugada.getJugada());
                jugadas.setHeridos(heridos);
                jugadas.setMuertos(muertos);
                listJugadas.add(jugadas);
                request.setAttribute("cantidadDigitos", cantidadDigitos);
                url = "/JSP/juego.jsp";
                request.setAttribute("numeroJugadas", listJugadas);
            }

            if (muertos == cantidadDigitos) {
                sigueJugando = false;
                request.setAttribute("numeroAleatorio", noSeRepite);
                request.setAttribute("numeroJugadas", numeroJugadas);
                url = "/JSP/acertado.jsp";
            }
        } else if(request.getParameter("si") != null){
            url = "index.html";
            numeroJugadas = 0;
            listJugadas.clear();
        } else if(request.getParameter("no") != null){
            url = "/JSP/adios.jsp";
        }
        

        request.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
