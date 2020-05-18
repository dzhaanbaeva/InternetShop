
window.addEventListener('load', function () {
// const serverPath = 'http://localhost:9292';


    let button = document.getElementById("searchId");
    button.addEventListener("click", function (e) {
        e.preventDefault();
        let searchForm = document.getElementById("login-form");
        let data = new FormData(searchForm);
        data.get(name);
        const dataJSON = JSON.stringify(Object.fromEntries(data));

        console.log(dataJSON)
        fetch("http://localhost:9292/product" + dataJSON , {
            method: "GET"
        }).then(response => {
            console.log(response.data,"++++++++++++++++=")
        })

            // window.location.href = "http://localhost:9292/product/" + data


    });




});

function addProduct(id){
    console.log(id, "HERE")
    // let name1 = "_csrf"
    // let name = document.getElementsByName("_csrf_header")[0].getAttribute("content")
    // let value = document.getElementsByName("_csrf_token")[0].getAttribute("content")
    // let data = new FormData();
    // data.append("id",id);
    // data.append(name1,value);
    //
    // let product = document.getElementById("product"+id)
    // if(product.classList.contains("fa-cart-plus")){
    //     product.classList.remove("fa-cart-plus")
    //     product.classList.add("fa-cart-arrow-down")
    // } else {
    //     product.classList.remove("fa-cart-arrow-down")
    //     product.classList.add("fa-cart-plus")
    // }
    //
    // fetch("http://localhost:8000/products/addInBasket/", {
    //     method: 'POST',
    //     body: data
    // }).then(r => r.json());
    // console.log(id);
    // console.log(name1);
    // console.log(value);

}

const getCurrentPage = () => {
    const loc = (typeof window.location !== 'string') ? window.location.search : window.location;
    const index = loc.indexOf('page=');
    return index === -1 ? 1 : parseInt(loc[index + 5]) + 1;
};

const constructGetUrl = (url, queryParams) => {
    for (let key in queryParams) {
        if (queryParams.hasOwnProperty(key)) {
            console.log(key, queryParams[key]);
        }
    }
    // TODO
};

(function loadPlacesPageable() {

    const placeTemplate = (listItem) => {
        const template = ` <div class="flex flex-column flex-v-center box-128">
            <a href="/places/${p.id}">
            <img src="/images/${p.image}" width="150" height="150">
            <p>${p.id} - ${p.name} </p>
            </a>
        </div>
        `;

        const elem = document.createElement('div');
        elem.innerHTML = template.trim();

        // return inner div with classes flex etc
        return elem.children[0];
    };

    const fetchPlaces = async (page, size) => {
        const placesPath = `${serverPath}/products?page=${page}&size=${size}`;
        const data = await fetch(placesPath, {cache: 'no-cache'});
        return data.json();
    };

    const loadNextPlacesGenerator = (loadNextElement, page) => {
        return async (event) => {
            event.preventDefault();
            event.stopPropagation();

            const defaultPageSize = loadNextElement.getAttribute('data-default-page-size');
            const data = await fetchPlaces(page, defaultPageSize);

            loadNextElement.hidden = data.length === 0;
            if (data.length === 0) {
                return;
            }

            const list = document.getElementById('itemList');
            for (let item of data) {
                list.append(placeTemplate(item));
            }

            loadNextElement.addEventListener('click', loadNextPlacesGenerator(loadNextElement, page + 1), {once: true});
            window.scrollTo(0, document.body.scrollHeight);
        };
    };
    // document.getElementById('loadPrev').hidden = true;
    // const loadNextElement = document.getElementById('loadNext');
    // if (loadNextElement !== null) {
    //     loadNextElement.innerText = "Load more places";
    //     loadNextElement.addEventListener('click', loadNextPlacesGenerator(loadNextElement, getCurrentPage()), {once: true});
    // }

})();


