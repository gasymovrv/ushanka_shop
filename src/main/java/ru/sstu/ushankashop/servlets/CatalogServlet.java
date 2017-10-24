package ru.sstu.ushankashop.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Пример сервлета
 */
public class CatalogServlet extends HttpServlet {


    public CatalogServlet() {
    }

    private static List<Item> ITEMS = Arrays.asList(
            new Item(0L,
                    "Hat-Ushanka",
                    "Warm and Cozy",
                    99.99,
                    1),
            new Item(1L,
                    "Warezhka",
                    "Not cold", 5.999999999679,
                    2)
    );


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //тестируем обработку параметров
        if(req.getParameter("a") != null){
            //выводим значение параметра "а"
            resp.getOutputStream().println(req.getParameter("a"));
            //выводим все значения параметра "а"
            resp.getOutputStream().println(Arrays.toString(req.getParameterValues("a")));
        }

        //тестируем обработку загаловка
        if (req.getHeader("Content-Type") != null) {
            if (req.getHeader("Content-Type").equals("application/xml")) {
                //сериализуем на xml и выводим в ответ(response)
                try {
                    JAXBContext context = JAXBContext.newInstance(ItemList.class);
                    Marshaller marshaller = context.createMarshaller();
                    marshaller.marshal(new ItemList(ITEMS), resp.getOutputStream());
                } catch (Exception e) {
                    throw new RuntimeException();
                }
            } else if (req.getHeader("Content-Type").equals("application/json")) {
                //тоже на json и выводим в ответ(response)
                ObjectMapper om = new ObjectMapper();
                om.writeValue(resp.getOutputStream(), ITEMS);
            }
        }
    }


//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        PrintWriter out = response.getWriter();
//        Item mydata = new Item();
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            // display to console
//            out.println(mapper.writeValueAsString(mydata));
//        } catch (JsonGenerationException e) {
//            e.printStackTrace();
//        } catch (JsonMappingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        out.close();
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        PrintWriter out = response.getWriter();
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            // read from file, convert it to user class
//            Item user = mapper.readValue(request.getReader(), Item.class);
//            // display to console
//            out.println(user);
//        } catch (JsonGenerationException e) {
//            e.printStackTrace();
//        } catch (JsonMappingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        out.close();
//    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
