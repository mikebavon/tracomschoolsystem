var courseUnit = {
    pageTitle : 'Course Units',
    data: [{
              name: "ALGORITHMS",
              code: 'A1444'
          },{
              name: "DISCRETE MATHEMATICS",
              code: "232323"
          },{
              name: "DATABASES",
              code: "2555o9888"
    }],
    list : function(){
        var me = this;

       var unitListTable = "<table border=\"1\"><tr><th>Name</th><th>Code<th></tr>";

       for (let index = 0; index < me.data.length; index++)
           unitListTable +=  "<tr><td>" + me.data[index].name + "</td><td>" + me.data[index].code + "<td></tr>";

       unitListTable += "</table>";

       document.getElementById("content").innerHTML = unitListTable;
    },
    add: function() {
        var addForm = "<form action=\"/action_page.php\">"+
              "<label for=\"cname\">Name:</label><br>"+
              "<input type=\"text\" id=\"cname\" name=\"cname\"><br>"+
              "<label for=\"ccode\">Code:</label><br>"+
              "<input type=\"text\" id=\"ccode\" name=\"ccode\"><br><br>"+
              "<input type=\"submit\" value=\"Submit\">"+
            "</form>";

        var addForm = "<form action=\"/action_page.php\">";
        this.form.forEach(field) {
               addForm += `<label for=\"{field.id}\">{field.label}</label><br>` +
                `<input type=\"{field.type}\" id=\"{field.id}\" name=\"{field.name}\"><br>`
        }

         document.getElementById("content").innerHTML = addForm;

    },
    save: function(){
        console.log("course unit")
    }
};