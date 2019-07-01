package com.softserve.ita.demo1.servletes.admin.item;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.entities.Category;
import com.softserve.ita.demo1.entities.Item;
import com.softserve.ita.demo1.services.impl.CategoryServiceImpl;
import com.softserve.ita.demo1.services.impl.ItemServiceImpl;
import com.softserve.ita.demo1.services.interfaces.CategoryService;
import com.softserve.ita.demo1.services.interfaces.ItemService;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@WebServlet(urlPatterns = "/admin/item/update/*")
@MultipartConfig
public class UpdateController extends HttpServlet {

    private CategoryService categoryService;
    private ItemService itemService;

    @Override
    public void init() throws ServletException {
        super.init();
        categoryService = new CategoryServiceImpl();
        itemService = new ItemServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Category> categories = categoryService.getAll();
            req.setAttribute("categories", categories);
        } catch (DAOException e) {
            throw new ServletException(e.getMessage());
        }

        ItemService itemService = new ItemServiceImpl();
        String path = req.getPathInfo();
        String id = path.split("/")[1];
        Integer itemId = null;

        try {
            itemId = Integer.valueOf(id);

            Item item = itemService.getById(itemId);
            if (item == null) {
                throw new NotFound();
            }
            req.setAttribute("item", item);
            req.getRequestDispatcher("/views/admin/item/edit.jsp").forward(req, resp);
        } catch (NumberFormatException | NotFound e) {
            resp.setStatus(404);
        } catch (DAOException e) {
            throw new ServletException(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String categoryIdString = req.getParameter("categories_id");
        String priceString = req.getParameter("price");
        String idString = req.getParameter("id");

        if (title == null || description == null || categoryIdString == null || priceString == null || idString == null) {
            resp.setStatus(400);
        } else {
            Integer categoryId = Integer.valueOf(categoryIdString);
            Integer price = Integer.valueOf(priceString);
            Integer id = Integer.valueOf(idString);

            try {
                Item item = itemService.getById(id);
                item.setPrice(price);
                item.setDescription(description);
                item.setTitle(title);
                item.setCategoriesId(categoryId);


                //----------------
                InputStream ImgInputStream = null; // input stream of the upload file

                // obtains the upload file part in this multipart request
                Part filePart = req.getPart("img");
                if (filePart != null) {
                    ByteArrayInputStream imgStream = (ByteArrayInputStream) filePart.getInputStream();
                    imgStream.toB
                    //
                    ArrayList<Byte> bytesList = new ArrayList<>();
                    byte ch;
                    while ((ch = (byte)ImgInputStream.read()) != -1) {
                        bytesList.add(ch);
                    }
                    byte[] bytes = new byte[bytesList.size()];
                    for (int i = 0; i < bytesList.size(); i++) {
                        bytes[i] = bytesList.get(i);
                    }

                    //ImgInputStream.read(bytes);//ByteStreams.toByteArray(in)ImgInputStream.get

                    String base64Img = Base64.getEncoder().encodeToString(bytes);
                    item.setImg(base64Img);

                    System.out.println(base64Img);
                    throw new ServletException(base64Img);
                   /* InputStream finput = new FileInputStream(file);
                    byte[] imageBytes = new byte[(int)file.length()];
                    finput.read(imageBytes, 0, imageBytes.length);
                    finput.close();
                    String imageStr = Base64.encodeBase64String(imageBytes);*/
                } else {
                    throw new ServletException("ss");
                }


               // itemService.update(item);

                //----------------
               // resp.sendRedirect("/admin/item/update/" + item.getId());
            } catch (DAOException e) {
                throw new ServletException(e.getMessage());
            } catch (NumberFormatException e) {
                resp.setStatus(400);
            }
        }

    }

    public static byte[] getImageById(String imageId) {
        ConnectionPool dataSource = ConnectionPool.getInstance();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String query = "SELECT image FROM books WHERE id = ?";
        try(Connection conn = dataSource.getConnection()){
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(imageId));

            rs =  stmt.executeQuery();

            rs.next();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            baos.write(rs.getBytes("image"));

            return baos.toByteArray();

        }catch (SQLException | IOException e){
            throw new DAOException(e.getMessage(), e);
        }finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
        }
    }

    protected void uploadFoto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create path components to save the file
        final String path = request.getParameter("destination");
        final Part filePart = request.getPart("file");
        final String fileName = getFileName(filePart);

        OutputStream out = null;
        InputStream filecontent = null;

        try {
            out = new FileOutputStream(new File(path + File.separator + fileName));
            filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
        } catch (FileNotFoundException fne) {
            throw new ServletException(fne.getMessage(), fne);

        } finally {
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
        }
    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}


/**
 *  Предзаказ 500ш
 *
 *
 *
 */
