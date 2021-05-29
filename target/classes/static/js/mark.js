
   //Markedan编辑器
   var contentEditor;
   $(function () {
       contentEditor = editormd("md-content", {
           width: "100%",
           height: 640,
           syncScrolling: "single",
           path: "/node_modules/editor.md/lib/"
       });


   });
