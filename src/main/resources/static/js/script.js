const selectImage = document.querySelector('.select-image');
const inputFile = document.querySelector('#file');
const imageArea = document.querySelector('.image-area')


selectImage.addEventListener('click' , function(){
    inputFile.click();
})


inputFile.addEventListener('change', function(){
    const image = this.files[0];
    console.log(image);
    const reader = new FileReader();
    reader.onload = ()=> {
        const allimg = imageArea.querySelectorAll('img')
        allimg.forEach(item=> item.remove());
        const imgUrl=reader.result;
        const img = document.createElement('img')
        img.src=imgUrl
        imageArea.appendChild(img)
        imageArea.classList.add('active');


    }
    reader.readAsDataURL(image);
})

