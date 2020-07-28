TracomAcademy.Grid.apply({
    contentRender: "content",
    gridTitle: "Units",
    componentId: "units",
    columns: [{
        header: "Id",
        dataIndex: "id",
        width: 10
    },{
        header: "Name",
        dataIndex: "name",
        width: 25
    },{
        header: "Address",
        dataIndex: "Address",
        width: 25
    },{
        header: "Location",
        dataIndex: "Location",
        width: 40
       }, {
         header: "Address",
         dataIndex: "Address",
         width: 25
            },{
         header: "Type",
         dataIndex: "Type",
         width: 25
    }],
    store: [{
            id: 1,
            name: "ALGORITHMS",
            address: "A1444",
            location: "JUST DESCRIPTION",
            type: "JUST DESCRIPTION"
        },










// An icon to show delete action
//const deleteIcon = '<i class="fa fa-trash"></i>';
//
//const manageInstitution = {
//    saveData(key, myLibrary) {
//        // Persistently store the data
//        localStorage.setItem(key, JSON.stringify(myLibrary));
//    },
//
//    getLibrary(key) {
//        let data = localStorage.getItem(key) ?
//            JSON.parse(localStorage.getItem(key)) : [];
//        return data;
//    },
//
//    updateChanges(storageKey, identifier, myLibrary) {
//        this.saveData(storageKey, myLibrary);
//        this.clearTable(identifier);
//        this.render(myLibrary);
//    },
//
//    addToLibrary(myLibrary, data, storageKey, identifier) {
//        myLibrary.push(data);
//        this.updateChanges(storageKey, identifier, myLibrary);
//    },
//
//    removeFromLibrary(myLibrary, id, storageKey, identifier) {
//        myLibrary.splice(id, 1);
//        this.updateChanges(storageKey, identifier, myLibrary);
//    },
//
//    clearTable(identifier) {
//        // delete all displayed records
//        let library = document.querySelector(identifier);
//        while (library.firstChild) {
//            library.removeChild(library.firstChild);
//        }
//    },
//
//    deleteLibrary(key) {
//        localStorage.removeItem(key);
//        myLibrary = this.getLibrary(key);
//        this.clearTable(key);
//        this.render(myLibrary);
//    },
//
//    // Event listeners
//    hideModal() {
//        let modal = document.querySelector(".add-modal");
//        modal.style.display = 'none';
//    },
//
//    showModal() {
//        let modal = document.querySelector(".add-modal");
//        modal.style.display = 'block';
//    },
//
//    createNewInst() {
//        // create an institution object using data obtained from user input
//        let name = document.querySelector("#name").value;
//        let address = document.querySelector("#address").value;
//        let location = document.querySelector("#location").value;
//        let type = document.querySelector("#type").value;
//
//        return { name, address, location, type };
//    },
//
//    render(myLibrary) {
//        let instList = document.querySelector("#inst-list");
//
//        // display all institutions in the library
//        myLibrary.forEach((inst, id) => {
//            let instInfo = document.createElement('tr');
//            let instKeys = Object.keys(inst);
//            instKeys.push("delete");
//
//            instKeys.forEach((key) => {
//                let entry = document.createElement('td');
//                if (key == "delete") {
//                    entry.innerHTML = deleteIcon;
//                    entry.classList.add('delete');
//                    entry.setAttribute("data-id", id);
//                    entry.addEventListener('click', function() {
//                        manageInstitution.removeFromLibrary(myLibrary, entry.dataset.id, "institution", "#inst-list");
//                    });
//
//                } else {
//                    entry.innerHTML = inst[key];
//                }
//                instInfo.appendChild(entry);
//            });
//
//            instList.appendChild(instInfo);
//        });
//    },
//
//
//    start() {
//        let STORAGE_KEY = "institution";
//        let myLibrary = this.getLibrary(this.STORAGE_KEY);
//
//
//        //let showModal = this.showModal;
//        let addBtn = document.querySelector("#add-btn");
//        addBtn.addEventListener("click", function() {
//            manageInstitution.showModal();
//        });
//
//        //let closeBtn = this.closeBtn;
//        let closeBtn = document.querySelector(".close");
//        closeBtn.addEventListener("click", function() {
//            manageInstitution.hideModal();
//        });
//
//        this.render(myLibrary);
//
//        //let hideModal = this.closeBtn;
//        let addInst = document.querySelector("#inst-info-form");
//        addInst.addEventListener("submit", function(e) {
//            // prevent default submit action which sends data to a server
//            e.preventDefault();
//            let inst = manageInstitution.createNewInst();
//            manageInstitution.addToLibrary(myLibrary, inst, STORAGE_KEY, "#inst-list");
//            manageInstitution.hideModal();
//        });
//    }
//
//}
//
//manageInstitution.start();