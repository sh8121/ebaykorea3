package examples.boot.springboard.controller;

import examples.boot.springboard.domain.Board;
import examples.boot.springboard.security.AuthUser;
import examples.boot.springboard.security.LoginUser;
import examples.boot.springboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.security.Principal;
import java.util.UUID;

@Controller
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    // /boards/writeform
    @GetMapping("/writeform")
    public String writeform(@AuthUser LoginUser loginUser,
                            ModelMap map){
        map.addAttribute("name", loginUser.getName());
        // 제목, 내용 입력.
        return "boards/writeform";
    }

    // view 가 없다. 출력자체가 결과
    @GetMapping("/download/{id}")
    @ResponseBody
    public void download(
            @PathVariable(name = "id") Long id,
            HttpServletResponse response){
        // 파일을 읽어서 response의 outputStream으로 출력한다.
        response.setContentType("text/plain");
        response.setContentLength(7780);
        InputStream in = null;
        OutputStream out = null;

        try{
            in = new FileInputStream("/tmp/2018/12/4/96e0dea1-99f3-41a9-8da9-60fde10dc1b7");
            out = response.getOutputStream();

            byte[] buffer = new byte[1024];
            int readCount = 0;

            // 2000 byte
            while((readCount = in.read(buffer)) != -1){
                // buffer배열의 0번째부터 readCount까지 써라.
                out.write(buffer,0, readCount);
                out.flush();
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @PostMapping
    public String write(@AuthUser LoginUser loginUser,
        @RequestParam(name = "title")String title,
        @RequestParam(name = "content")String content,
        @RequestParam("uploadFile") MultipartFile uploadFile
    ){
        Assert.hasText(title, "제목을 입력하세요.");
        Assert.hasText(content, "내용을 입력하세요.");
        System.out.println(uploadFile.getOriginalFilename());
        System.out.println(uploadFile.getContentType());
        System.out.println(uploadFile.getSize());
        InputStream in = null;
        OutputStream out = null;
        try{
            in = uploadFile.getInputStream();
            String dir = "/tmp/2018/12/4";
            String fileName = dir + "/" + UUID.randomUUID();
            File file = new File(dir);
            file.mkdirs();

            out = new FileOutputStream(fileName);

            byte[] buffer = new byte[1024];
            int readCount = 0;

            // 2000 byte
            while((readCount = in.read(buffer)) != -1){
                // buffer배열의 0번째부터 readCount까지 써라.
                out.write(buffer,0, readCount);
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        boardService.addBoard(loginUser.getUserId(),
                title, content);
        return "redirect:/boards";
    }

    @GetMapping
    public String boards(
            @RequestParam(name = "page",
                    required = false,
                    defaultValue = "1"
            ) int page,
            ModelMap modelMap){
        if(page < 1) page = 1;

        Page<Board> boardPage =
                boardService.getBoards(page);
        modelMap.addAttribute("boardPage",
                boardPage);

        return "boards/list"; // view name
    }
}

/*
/WEB-INF/jsp/  + viewname + .jsp

spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
 */