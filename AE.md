# Additional Explanation

### Model m
- Model 클래스는 컨트롤러와 뷰 간에 데이터를 전달하는 데 사용됨

### MultipartFile
- A representation of an uploaded file received in a multipart request.
- The file contents are either stored in memory or temporarily on disk. 
- In either case, the user is responsible for copying file contents to a session-level or persistent store as and if desired. 
- The temporary storage will be cleared at the end of request processing.