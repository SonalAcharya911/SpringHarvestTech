<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Ice Blue Themed Index Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-info bg-opacity-25 text-dark min-vh-100 d-flex flex-column justify-content-center align-items-center">

<div class="container text-center p-4 border border-info rounded-4 shadow-lg bg-white bg-opacity-75" style="max-width: 600px;">

<!--    <a href="Contact.jsp" class="btn btn-info fw-semibold px-4 py-2 rounded-pill mb-4">Fill in new Contact</a>-->

    <form action="submit" method="post" class="text-start">
        <div class="mb-3">
            <label for="name" class="form-label fw-semibold">Name</label>
            <input type="text" id="name" name="name" class="form-control" placeholder="Enter your name" required>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label fw-semibold">Email</label>
            <input type="email" id="email" name="email" class="form-control" placeholder="you@example.com" required>
        </div>
        <div class="mb-3">
            <label for="mobile" class="form-label fw-semibold">Mobile Number</label>
            <input type="tel" id="mobile" name="mobile" class="form-control" placeholder="e.g. 9876543210" required>
        </div>
        <div class="mb-3">
            <label for="comments" class="form-label fw-semibold">Comments</label>
            <textarea id="comments" name="comments" class="form-control" rows="3" placeholder="Your message..."></textarea>
        </div>
        <div class="mb-3">
            <label for="multipartFile" class="form-label fw-semibold">Id Proof</label>
            <input type="file" id="multipartFile" name="multipartFile" class="form-control" placeholder="choose a file" required>
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-info fw-semibold px-4 py-2 rounded-pill">Submit</button>
        </div>
    </form>
</div>

</body>
</html>
